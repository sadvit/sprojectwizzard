function UsersController(UsersResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    this.init();
}

UsersController.prototype.init = function() {
    var self = this;
    self.UsersResource.loadAll(function(users) {
        console.log(JSON.stringify(users));
        self.users = users;
    })
};

UsersController.prototype.editUser = function (userId) {
    this.$location.path('users/users_edit/' + userId);
};

UsersController.prototype.employeeLabel = function (role) {
    switch (role) {
        case "ANALYST": return 'Аналитик';
        case "PROGRAMMER": return 'Разработчик';
        case "LEADER": return 'Старший разработчик';
    }
    return 'Нет';
};

UsersController.prototype.managerLabel = function (manager) {
    return manager == undefined ? 'Нет' : 'Да';
};

angular.module('spwizzard').controller('UsersController', UsersController);