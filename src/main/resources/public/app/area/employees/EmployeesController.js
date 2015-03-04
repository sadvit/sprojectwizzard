function EmployeesController(EmployeesResource, TeamsResource, Session) {
    Object.defineProperty(this, 'EmployeesResource', { writable: true, value: EmployeesResource });
    Object.defineProperty(this, 'TeamsResource', { writable: true, value: TeamsResource });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });

    this.isEditMode = this.Session().employees == 1;

    this.init();
}

EmployeesController.prototype.init = function() {
    var self = this;
    self.TeamsResource.loadAll(function(teams) {
        console.log(JSON.stringify(teams));
        self.teams = teams;
        self.selectTeam(teams[0].id);
    });
};

EmployeesController.prototype.selectTeam = function(teamId) {
    var self = this;
    if (teamId != undefined) {
        self.currentTeamId = teamId;
        self.TeamsResource.loadUsers({id: teamId}, function(users) {
            self.users = users;
        })
    }
};

angular.module('spwizzard').controller('EmployeesController', EmployeesController);