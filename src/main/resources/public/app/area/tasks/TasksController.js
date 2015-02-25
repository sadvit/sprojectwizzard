function TasksController(ProjectsResource, TasksResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource }); // TODO переделать под ресурсы задач tasks
    Object.defineProperty(this, 'TasksResource', { writable: true, value: TasksResource }); // TODO переделать под ресурсы задач tasks

    this.tasksForProject = {};
    this.projects = {};

    this.init();
}

TasksController.prototype.init = function() {
    var self = this;
    self.ProjectsResource.loadAll({}, function(data) {
        self.projects = data;
        self.updateTasks(data[0].id);
    });
};

TasksController.prototype.updateTasks = function(id) {
    var self = this;
    this.TasksResource.getByProjectId({
        projectId: id
    }, function(data) {
        self.tasksForProject = data;
    });
};

TasksController.prototype.editTask = function(index) {
    var taskId = this.tasksForProject[index].id;
    console.log('index: ' + taskId);
    this.$location.path('tasks/tasks_edit/' + taskId);
};

angular.module('spwizzard').controller('TasksController', TasksController);
