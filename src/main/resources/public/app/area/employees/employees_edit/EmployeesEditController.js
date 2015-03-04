function EmployeesEditController(EmployeesResource, TeamsResource, $routeParams, Session) {
    Object.defineProperty(this, 'EmployeesResource', { writable: true, value: EmployeesResource });
    Object.defineProperty(this, 'TeamsResource', { writable: true, value: TeamsResource });
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });

    this.isEditMode = this.Session().employees == 1;
    this.teamId = this.$routeParams.id;
    this.teamCreation = this.teamId === undefined;

    this.init();
}

EmployeesEditController.prototype.init = function() {
    var self = this;
    self.EmployeesResource.loadAnalysts(function(analysts) {
        console.log(JSON.stringify(analysts));
        self.analysts = analysts;
    });
    self.EmployeesResource.loadLeaders(function(leaders) {
        console.log(JSON.stringify(leaders));
        self.leaders = leaders;
    });
    self.EmployeesResource.loadProgrammers(function(programmers) {
        console.log(JSON.stringify(programmers));
        self.programmers = programmers;
    });

    if(!self.teamCreation) {
        self.TeamsResource.load({
            id: self.teamId
        }, function(data) {
            alert(JSON.stringify(data));
        });
    }
};

EmployeesEditController.prototype.saveTeam = function() {
    var self = this;
    var team = {
        name : self.teamName,
        employees : [
            self.analyst.employee,
            self.programmer.employee,
            self.leader.employee
        ]
    };
    console.log(JSON.stringify(team));

    self.TeamsResource.save(team, function() {
        console.log('done');
    });
};

angular.module('spwizzard').controller('EmployeesEditController', EmployeesEditController);