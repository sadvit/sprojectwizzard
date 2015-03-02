function TasksEditController(TasksResource, $routeParams, $location, UsersResource, RequirementsResource) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'TasksResource', { writable: true, value: TasksResource });
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });

    this.taskId = this.$routeParams.id;
    this.projectId = this.$location.absUrl().split('=')[1];
    this.taskCreation = this.taskId === undefined;
    this.task = {};

    var self = this;

    self.UsersResource.loadAllForProject({
            projectId: self.projectId
        }, function(data) {
            self.employees = data;
            self.task.employee = data[0];
    });

    self.RequirementsResource.loadAllForProject({
        projectId: self.projectId
    }, function(data) {
        self.requirements = data;
        self.task.requirement = data[0];
    });

    if(this.taskCreation) {
        this.action = "Создать";
        this.task = {
            name: "",
            description: "",
            difficulty: 0,
            openDate: new Date(),
            closeDate: new Date()
        };
    } else {
        this.action = "Обновить";
        this.init();
    }
}

TasksEditController.prototype.init = function() {
    var self = this;

    self.TasksResource.load({
        id: self.taskId
    }, function (data) {
        self.task = data;
        self.task.openDate = new Date(data.openDate);
        self.task.closeDate = new Date(data.closeDate);
    }, function(error) {
        console.error('Error loading task.');
    });
};

TasksEditController.prototype.saveTask = function() {
    var self = this;

    if(self.taskCreation) {
        self.TasksResource.save(self.task, function () {
            console.log('task saved');
            self.$location.path('tasks');
        });
    } else {
        self.TasksResource.update(self.task, function() {
            console.log('task updated');
            self.$location.path('tasks');
        });
    }
};

angular.module('spwizzard').controller('TasksEditController', TasksEditController);
