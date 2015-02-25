function TasksController(ProjectsResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource }); // TODO переделать под ресурсы задач tasks
    this.init();
}

TasksController.prototype.init = function() {
    var self = this;
    self.ProjectsResource.projects.getAll({}, function(data) {
        self.projects = data;
    });
};

TasksController.prototype.editTask = function(index) {
    console.log('index: ' + index);
    this.$location.path('tasks/tasks_edit');
};

angular.module('spwizzard').controller('TasksController', TasksController);
