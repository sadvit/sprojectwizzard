function IndexController(Session, EventBus, $cookieStore, $location) {
    Object.defineProperty(this, 'session', { writable: true, value: Session });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    EventBus.register('IndexController', this);
}

IndexController.prototype.refresh = function() {
    var session = this.session();
    this.projectsAccess = session.projects >= 0;
    this.tasksAccess = session.tasks >= 0;
    this.employeesAccess = session.employees >= 0;
    this.requirementsAccess = session.requirements >= 0;
    this.usersAccess = session.users >= 0;
    this.profileAccess = session.profile >= 0;
    this.exitAccess = session.exit >= 0;
};

IndexController.prototype.handleMessage = function() {
    this.refresh();
};

/**
 * Выход осуществляется следующим образом:
 * 1. Стирается обьект user из cookies
 * 2. Рефрешится index.html
 * 3. Срабатывает перенаправление на страницу входа в систему.
 */
IndexController.prototype.exit = function() {
    this.cookies.remove('user');
    this.cookies.remove('id');
    this.refresh();
    this.$location.path('login');
};

angular.module('spwizzard').controller('IndexController', IndexController);