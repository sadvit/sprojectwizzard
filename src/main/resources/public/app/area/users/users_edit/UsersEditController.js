function UsersEditController(UsersResource, $routeParams) {
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    this.userId = this.$routeParams.id;
    this.userCreation = this.userId !== undefined;
    this.init();
}

UsersEditController.prototype.init = function() {
    var self = this;
    if (!self.userCreation) {
        self.user = {};
    } else {
        self.UsersResource.load({id: self.userId}, function (user) {
            console.log('user: ' + user);
            self.user = user;
        });
    }
};

UsersEditController.prototype.saveUser = function() {
    var self = this;
    console.log('self user: ' + JSON.stringify(self.user));
    self.UsersResource.save(self.user, function() {
        console.log('saved');
    })
};

UsersEditController.prototype.deleteUser = function() {
    console.log("delete: " + JSON.stringify(this.user));
};

angular.module('spwizzard').controller('UsersEditController', UsersEditController);