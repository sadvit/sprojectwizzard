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

EmployeesController.prototype.editEmployee = function(employeeId) {
    this.$location.path('employees/employees_edit/' + employeeId);
};

EmployeesController.prototype.selectTeam = function(teamId) {
    var self = this;
    console.log(teamId);
    if (teamId != undefined) {
        self.TeamsResource.loadEmployees({id: teamId}, function(employees) {
            console.log(JSON.stringify(employees));
            self.employees = employees;
        })
    }
};

angular.module('spwizzard').controller('EmployeesController', EmployeesController);