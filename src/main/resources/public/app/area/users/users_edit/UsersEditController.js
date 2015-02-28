function UsersEditController(UsersResource, $routeParams, $location) {
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'location', { writable: true, value: $location });
    this.init();
}

UsersEditController.prototype.init = function() {
    var self = this;

    self.userId = self.$routeParams.id;
    console.log('ID: ' + self.userId);
    self.isUpdate = self.userId !== undefined;

    if (self.isUpdate) {
        self.UsersResource.load({id: self.userId}, function (user) {
            self.user = user;
            self.user.isManager = user.manager !== undefined;
        });
    } else {
        self.user = {isManager: false};
        self.user.employee = {};
        self.user.employee.role = 'ANALYST';
    }
};

UsersEditController.prototype.saveUser = function() {
    var self = this;
    var cleanUser = CleanProperties(self.user);
    if (self.isUpdate) {
        self.UsersResource.update(cleanUser, function() {
            self.location.path('/users');
        });
    } else {
        self.UsersResource.save(cleanUser, function() {
            self.location.path('/users');
        });
    }
};

/**
 * Обрезает обьект User под правильный формат
 */
function CleanProperties(user) {
    if (user.isManager === true) {
        delete user.employee;
        user.manager = {};
    } else {
        delete user.manager;
    }
    delete user.isManager;
    //console.log('CleanUser: ' + JSON.stringify(user));
    return user;
}

UsersEditController.prototype.deleteUser = function() {
    var self = this;
    console.log("delete: " + JSON.stringify(self.user));
    self.UsersResource.delete({id: self.user.id}, function() {
        self.location.path('/users');
    });
};

angular.module('spwizzard').controller('UsersEditController', UsersEditController);