function EmployeesEditController(EmployeesResource, TeamsResource, $routeParams, Session, $location) {
    Object.defineProperty(this, 'EmployeesResource', { writable: true, value: EmployeesResource });
    Object.defineProperty(this, 'TeamsResource', { writable: true, value: TeamsResource });
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });
    Object.defineProperty(this, '$location', { writable: true, value: $location });

    this.teamId = this.$routeParams.id;
    this.teamCreation = this.teamId === undefined;
    this.team = {};
    this.action = this.teamCreation ? 'Создать' : 'Обновить';

    this.init();
}

EmployeesEditController.prototype.init = function() {
    var self = this;
    self.EmployeesResource.loadAnalysts(function(analysts) {
        console.log(JSON.stringify(analysts));
        self.analysts = analysts;
        if(analysts.length > 0) self.analyst = analysts[0];
    });
    self.EmployeesResource.loadLeaders(function(leaders) {
        console.log(JSON.stringify(leaders));
        self.leaders = leaders;
        if(leaders.length > 0) self.leader = leaders[0];
    });
    self.EmployeesResource.loadProgrammers(function(programmers) {
        console.log(JSON.stringify(programmers));
        self.programmers = programmers;
        if(programmers.length > 0) self.programmer = programmers[0];
    });

    if(!self.teamCreation) {
        self.TeamsResource.load({
            id: self.teamId
        }, function(data) {
            self.team.name = data.name;
        });

        self.TeamsResource.loadUsers({
            id: self.teamId
        }, function(data) {
            data.forEach(function(e) {
                switch(e.employee.role) {
                    case 'PROGRAMMER':
                        self.programmer = e;
                        self.programmers.push(e);
                        break;
                    case 'LEADER':
                        self.leader = e;
                        self.leaders.push(e);
                        break;
                    case 'ANALYST':
                        self.analyst = e;
                        self.analysts.push(e);
                        break;
                }
            });
        });
    } else {
        self.team.name = "";
    }
};

EmployeesEditController.prototype.saveTeam = function() {
    var self = this;
    var team = {
        name : self.team.name,
        employees : [
            self.analyst.employee,
            self.programmer.employee,
            self.leader.employee
        ]
    };
    console.log(JSON.stringify(team));

    if(self.teamCreation) {
        self.TeamsResource.save(team, function () {
            console.log('done');
            self.redirect();
        });
    } else {
        self.TeamsResource.update(team, function () {
            console.log('done');
            self.redirect();
        });
    }
};

EmployeesEditController.prototype.deleteTeam = function() {
    var self = this;
    self.TeamsResource.delete({
        id: self.teamId
    }, function() {
        console.log('Team deleted!');
        self.redirect();
    });
};

EmployeesEditController.prototype.redirect = function() {
    this.$location.path('employees/');
};

angular.module('spwizzard').controller('EmployeesEditController', EmployeesEditController);