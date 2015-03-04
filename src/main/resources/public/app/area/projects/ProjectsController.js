function ProjectsController(ProjectsResource, $location, Session) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'resource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'session', { writable: true, value: Session });

    this.init();
}

ProjectsController.prototype.init = function() {
    this.isEditMode = this.session().projects == 1;
    this.leftStyle = this.isEditMode ? 'main-column' : 'single-column';
    var self = this;
    self.resource.loadAll({}, function(projects) {
        self.projects = projects;
    });
};

ProjectsController.prototype.editProject = function(projectId) {
    this.$location.path('projects/project_edit/' + projectId);
};

angular.module('spwizzard').controller('ProjectsController', ProjectsController);