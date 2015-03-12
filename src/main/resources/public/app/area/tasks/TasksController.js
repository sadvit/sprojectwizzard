function TasksController(ProjectsResource, TasksResource, $location, Session) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'TasksResource', { writable: true, value: TasksResource });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });

    this.tasksForProject = {};
    this.projects = {};
    this.isEditMode = this.Session().tasks == 1;

    this.init();
}

TasksController.prototype.init = function() {
    var self = this;
    self.ProjectsResource.loadAll({}, function(data) {
        self.projects = data;
        if(data.length > 0) {
            self.currentProjectId = data[0].id;
            self.updateTasks(data[0].id);
        }
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

TasksController.prototype.determineStyle = function(status) {
    switch(status) {
        case 'NEW': {
            return 'new-task';
        }
        case 'IN_PROGRESS': {
            return 'progress-task';
        }
        case 'DONE': {
            return 'done-task';
        }
        default: {
            return 'open-task';
        }
    }
};

angular.module('spwizzard').controller('TasksController', TasksController);
