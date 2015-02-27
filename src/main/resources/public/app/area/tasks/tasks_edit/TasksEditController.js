function TasksEditController(TasksResource, $routeParams) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'TasksResource', { writable: true, value: TasksResource }); // TODO переделать под ресурсы задач tasks

    this.taskId = this.$routeParams.id;
    this.taskCreation = this.taskId !== undefined;

    this.workers = [{
        name: 'Aleksey'
    }, {
        name: 'Vitaly'
    }];
    this.workerChoice = this.workers[0];

    if(this.taskCreation) {
        this.title = "Редактирование задачи";
        this.init();
    } else {
        this.title = "Создание задачи";
        this.task = {
            name: "",
            description: "",
            openDate: new Date(),
            closeDate: new Date()
        };
    }
}

TasksEditController.prototype.init = function() {
    var self = this;

    self.TasksResource.getById({
        id: self.taskId
    }, function (data) {
        self.task = data;
        self.task.openDate = new Date(data.openDate);
        self.task.closeDate = new Date(data.closeDate);
    }, function(error) {
        console.error('Error loading task.')
    });
};

TasksEditController.prototype.saveTask = function() {
    var self = this;
    self.TasksResource.save(self.task, function() {
        console.log('task saved');
    });
};

angular.module('spwizzard').controller('TasksEditController', TasksEditController);
