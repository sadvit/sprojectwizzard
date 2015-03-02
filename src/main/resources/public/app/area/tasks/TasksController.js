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
        self.currentProjectId = data[0].id;
        self.updateTasks(data[0].id);
    });
};

TasksController.prototype.updateTasks = function(id) {
    var self = this;
    self.currentProjectId = id;
    this.TasksResource.getByProjectId({
        projectId: id
    }, function(data) {
        self.tasksForProject = data;

        self.tasksForProject.forEach(function(task) {
            self.TasksResource.loadTaskRequirement({
                id: task.id
            }, function(data) {
                task.requirement = data;
            });
        });
    });
};

TasksController.prototype.editTask = function(taskId) {
    var self = this;
    this.$location.search('projectId', self.currentProjectId).path('tasks/tasks_edit/' + taskId);
};

TasksController.prototype.createTask = function() {
    var self = this;
    this.$location.search('projectId', self.currentProjectId).path('tasks/tasks_edit');
};

angular.module('spwizzard').controller('TasksController', TasksController);
