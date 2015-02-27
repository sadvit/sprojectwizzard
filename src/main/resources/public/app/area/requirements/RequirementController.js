function RequirementController($location, ProjectsResource, RequirementsResource) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });

    this.requirementsForProject = {};
    this.projects = {};

    this.init();
}

RequirementController.prototype.init = function() {
    var self = this;
    self.ProjectsResource.loadAll({}, function(data) {
        self.projects = data;
        self.updateRequirements(data[0].id);
    });
};

RequirementController.prototype.updateRequirements = function(id) {
    var self = this;
    this.RequirementsResource.loadAllForProject({
        projectId: id
    }, function(data) {
        self.requirementsForProject = data;
    });
};

RequirementController.prototype.editRequirement = function(requirementId) {
    this.$location.path('requirements/edit/' + requirementId);
};

angular.module('spwizzard').controller('RequirementController', RequirementController);