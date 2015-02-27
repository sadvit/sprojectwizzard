function RequirementsEditController(RequirementsResource, $routeParams) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource }); // TODO переделать под ресурсы задач tasks

    this.requirementId = this.$routeParams.id;
    this.requirementCreation = this.requirementId !== undefined;

    this.workers = [{
        name: 'Aleksey'
    }, {
        name: 'Vitaly'
    }];
    this.workerChoice = this.workers[0];

    if(this.requirementCreation) {
        this.title = "Редактирование требования";
        this.init();
    } else {
        this.title = "Создание требования";
        this.requirement = {
            name: "",
            description: ""
        };
    }
}

RequirementsEditController.prototype.init = function() {
    var self = this;

    self.RequirementsResource.load({
        id: self.requirementId
    }, function (data) {
        self.requirement = data;
    }, function(error) {
        console.error('Error loading task.')
    });
};

RequirementsEditController.prototype.saveRequirement = function() {
    var self = this;
    self.TasksResource.save(self.task, function() {
        console.log('Requirement saved');
    });
};

angular.module('spwizzard').controller('RequirementsEditController', RequirementsEditController);
