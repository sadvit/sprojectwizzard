function ProfileController(UsersResource, $cookieStore) {
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    this.init();
}

ProfileController.prototype.init = function() {
    var self = this;
    self.user = self.cookies.get('user');
};

angular.module('spwizzard').controller('ProfileController', ProfileController);
