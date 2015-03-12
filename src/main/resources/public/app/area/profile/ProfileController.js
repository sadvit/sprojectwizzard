function ProfileController(UsersResource, $cookieStore) {
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    this.init();
}

ProfileController.prototype.init = function() {
    var self = this;
    self.user = self.cookies.get('user');
    if (self.user.employee != undefined) {
        self.role = self.user.employee.role;
    } else {
        self.role = 'MANAGER';
    }
};

angular.module('spwizzard').controller('ProfileController', ProfileController);
