function EmployeesController(EmployeesResource, TeamsResource) {
    Object.defineProperty(this, 'EmployeesResource', { writable: true, value: EmployeesResource });
    Object.defineProperty(this, 'TeamsResource', { writable: true, value: TeamsResource });
    this.init();
}

EmployeesController.prototype.init = function() {
    var self = this;
    self.TeamsResource.loadAll(function(teams) {
        console.log(JSON.stringify(teams));
        self.teams = teams;
    });
};

// TODO not used хотя может быть по клику стоит переходить к редактированию команды?
EmployeesController.prototype.editEmployee = function(employeeId) {
    //this.$location.path('employees/employees_edit/' + employeeId);
};

EmployeesController.prototype.selectTeam = function(teamId) {
    var self = this;
    //console.log(teamId);
    if (teamId != undefined) {
        self.TeamsResource.loadUsers({id: teamId}, function(users) {
            //console.log(JSON.stringify(users));
            self.users = users;
        })
    }
};

angular.module('spwizzard').controller('EmployeesController', EmployeesController);