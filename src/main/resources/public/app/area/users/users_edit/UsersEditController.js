function UsersEditController(UsersResource) {
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    this.init();
}

UsersEditController.prototype.init = function() {
    // TODO реализовать загрузку выбранного пользователя в поля форм
    this.user = {};
};

UsersEditController.prototype.saveUser = function() {
    console.log("save: " + JSON.stringify(this.user));
    var self = this;
    self.UsersResource.save(self.user, function() {
        console.log('saved');
    })
};

UsersEditController.prototype.deleteUser = function() {
    console.log("delete: " + JSON.stringify(this.user));
};

angular.module('spwizzard').controller('UsersEditController', UsersEditController);