function RequirementsEditController(RequirementsResource, $routeParams, $location, Session) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });

    this.requirementId = this.$routeParams.id;
    this.projectId = this.$location.absUrl().split('=')[1];
    this.requirementCreation = this.requirementId === undefined;
    this.isEditMode = this.Session().requirements == 1;

    var self = this;

    if(this.requirementCreation) {
        this.action = "Создать";
        this.requirement = {
            name: "",
            description: "",
            project: {
                id: self.projectId
            }
        };
    } else {
        this.action = "Обновить";
        this.init();

    }

    if(!this.isEditMode) this.action = "Просмотреть";
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

RequirementsEditController.prototype.submitRequirement = function() {
    if(this.requirementCreation) {
        this.saveRequirement();
    } else {
        this.updateRequirement();
    }
};

RequirementsEditController.prototype.saveRequirement = function() {
    var self = this;
    self.RequirementsResource.save(self.requirement, function() {
        console.log(JSON.stringify(self.requirement));
        console.log('Requirement saved');
        self.$location.path('requirements');
    });
};

RequirementsEditController.prototype.updateRequirement = function() {
    var self = this;
    self.RequirementsResource.update(self.requirement, function() {
        console.log(JSON.stringify(self.requirement));
        console.log('Requirement updated');
        self.$location.path('requirements');
    });
};

RequirementsEditController.prototype.deleteRequirement = function() {
    var self = this;
    if(confirm('Rly??')) {
        self.RequirementsResource.delete({
            id: self.requirementId
        }, function() {
            console.log('deleted');
            self.$location.path('requirements');
        });
    }
};

angular.module('spwizzard').controller('RequirementsEditController', RequirementsEditController);
