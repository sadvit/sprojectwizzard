function IndexController(Session) {
    Object.defineProperty(this, 'session', { writable: true, value: Session });
    this.init();
}

IndexController.prototype.init = function() {
    console.log(this.session);
    //console.log('RIGHTS: ' + JSON.stringify(this.session));
    this.projectsAccess = this.session.projects >= 0;
    this.tasksAccess = this.session.tasks >= 0;
    this.employeesAccess = this.session.employees >= 0;
    this.requirementsAccess = this.session.requirements >= 0;
    this.usersAccess = this.session.users >= 0;
    this.profileAccess = this.session.profile >= 0;
    this.exitAccess = this.session.exit >= 0;
};

angular.module('spwizzard').controller('IndexController', IndexController);