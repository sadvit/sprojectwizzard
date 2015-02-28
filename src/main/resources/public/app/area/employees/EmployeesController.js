function EmployeesController(EmployeesResource) {
    Object.defineProperty(this, 'EmployeesResource', { writable: true, value: EmployeesResource });
    this.init();
}

EmployeesController.prototype.init = function() {
    var self = this;
    self.EmployeesResource.loadAll({}, function(employees) {
        console.log(JSON.stringify(employees));
        self.employees = employees;
    })
};

EmployeesController.prototype.editEmployee = function(employeeId) {
    this.$location.path('employees/employees_edit/' + employeeId);
};

angular.module('spwizzard').controller('EmployeesController', EmployeesController);