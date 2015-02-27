function ProjectsController(ProjectsResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'resource', { writable: true, value: ProjectsResource });
    this.init();
}

ProjectsController.prototype.init = function() {
    var self = this;
    self.resource.loadAll({}, function(projects) {
        self.projects = projects;
    });
};

ProjectsController.prototype.editProject = function(projectId) {
    this.$location.path('projects/project_edit/' + projectId);
};

angular.module('spwizzard').controller('ProjectsController', ProjectsController);