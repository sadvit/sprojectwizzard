function RequirementController($location, ProjectsResource, RequirementsResource, Session) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });
    Object.defineProperty(this, 'Session', { writable: true, value: Session });

    this.requirementsForProject = {};

    this.init();
}

RequirementController.prototype.init = function() {
    var self = this;
    self.isEditMode = self.Session().requirements == 1;

    self.ProjectsResource.loadAll({}, function(data) {
        self.projects = data;
        self.currentProjectId = data[0].id;
        self.updateRequirements(self.currentProjectId);
    });
};

RequirementController.prototype.updateRequirements = function(id) {
    var self = this;
    self.currentProjectId = id;
    this.RequirementsResource.loadAllForProject({
        projectId: id
    }, function(data) {
        self.requirementsForProject = data;
    });
};

RequirementController.prototype.editRequirement = function(requirementId) {
    var self = this;
    this.$location.search('projectId', self.currentProjectId).path('requirements/requirements_edit/' + requirementId);
};

RequirementController.prototype.createRequirement = function() {
    var self = this;
    this.$location.search('projectId', self.currentProjectId).path('requirements/requirements_edit');
};

angular.module('spwizzard').controller('RequirementController', RequirementController);