function TasksEditController(ProjectsResource, TasksResource, $routeParams) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource }); // TODO переделать под ресурсы задач tasks
    Object.defineProperty(this, 'TasksResource', { writable: true, value: TasksResource }); // TODO переделать под ресурсы задач tasks

    this.taskId = this.$routeParams.id;
    this.dt = new Date();
    this.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };
    this.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    this.format = this.formats[0];

    this.init();
}

TasksEditController.prototype.todayDate = function() {
    self.dt = new Date();
};

TasksEditController.prototype.clearDate = function () {
    self.dt = null;
};

// Disable weekend selection
TasksEditController.prototype.dateDisabled = function(date, mode) {
    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
};

TasksEditController.prototype.toggleMin = function() {
    self.minDate = self.minDate ? null : new Date();
};

TasksEditController.prototype.open = function($event) {
    $event.preventDefault();
    $event.stopPropagation();

    self.opened = true;
};

TasksEditController.prototype.init = function() {
    /*var self = this;
    self.ProjectsResource.loadAll({}, function(data) {
        self.projects = data;
    });*/

    var self = this;

    self.todayDate();
    self.toggleMin();
};

angular.module('spwizzard').controller('TasksEditController', TasksEditController);
