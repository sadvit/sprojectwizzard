function UsersEditController(UsersResource, $routeParams) {
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    this.userId = this.$routeParams.id;
    this.isUpdate = this.userId !== undefined;
    this.init();
}

UsersEditController.prototype.init = function() {
    var self = this;
    if (self.isUpdate) {
        self.UsersResource.load({id: self.userId}, function (user) {
            console.log('user: ' + user);
            self.user = user;
        });
    } else {
        self.user = {};
    }
};

UsersEditController.prototype.saveUser = function() {
    var self = this;
    if (self.isUpdate) {
        self.UsersResource.update(self.user, function() {
            console.log('update')
        })
    } else {
        self.UsersResource.save(self.user, function() {
            console.log('saved')
        })
    }
};

UsersEditController.prototype.deleteUser = function() {
    console.log("delete: " + JSON.stringify(this.user));
};

angular.module('spwizzard').controller('UsersEditController', UsersEditController);