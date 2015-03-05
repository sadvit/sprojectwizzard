function TasksEditController(TasksResource, $routeParams, $location, UsersResource, RequirementsResource, Session, $cookieStore) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'TasksResource', { writable: true, value: TasksResource });
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });
    Object.defineProperty(this, '$cookieStore', { writable: true, value: $cookieStore });

    this.taskId = this.$routeParams.id;
    this.projectId = this.$location.absUrl().split('=')[1];
    this.taskCreation = this.taskId === undefined;
    this.task = {};
    this.isEditMode = this.Session().tasks == 1;
    this.viewerRole = this.Session().role;

    var self = this;

    if(self.taskCreation) {
        self.action = "Создать";
        self.task = {
            name: "",
            description: "",
            difficulty: 0,
            openDate: new Date(),
            closeDate: new Date()
        };
    } else {
        self.action = "Обновить";
        self.init();
    }

    if(!this.isEditMode) this.action = "Просмотреть";

    self.UsersResource.loadAllForProject({
            projectId: self.projectId
        }, function(data) {
            var newData = data.filter(function(e) {
                return e.employee.role !== 'ANALYST';
            });
            self.employees = newData;
            alert(JSON.stringify(self.employees));
    });

    self.RequirementsResource.loadAllForProject({
        projectId: self.projectId
    }, function(data) {
        self.requirements = data;
    });
}

TasksEditController.prototype.init = function() {
    var self = this;

    self.TasksResource.load({
        id: self.taskId
    }, function (data) {
        self.task = data;
        self.task.openDate = new Date(data.openDate);
        self.task.closeDate = new Date(data.closeDate);

        self.isMyTask = false;
        self.TasksResource.loadTaskUser({
            id: data.id
        }, function(data) {
            alert(JSON.stringify(data));
            self.task.employee = data.employee;
            if(self.$cookieStore.get('user').id === data.id) self.isMyTask = true;
        });

        self.TasksResource.loadTaskRequirement({
            id: data.id
        }, function(data) {
            self.task.requirement = data;
        });
    }, function(error) {
        console.error('Error loading task. Error status ' + error.status);
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

TasksEditController.prototype.setTaskStatus = function(status) {
    var self = this;

    self.TasksResource.updateStatus({id: self.taskId}, status, function() {
        console.log('task\'s status updated');
        self.$location.path('tasks');
    });
};

TasksEditController.prototype.deleteTask = function() {
    var self = this;

    self.TasksResource.delete({id: self.taskId}, function() {
        console.log('task deleted');
        self.$location.path('tasks');
    });
};

angular.module('spwizzard').controller('TasksEditController', TasksEditController);
