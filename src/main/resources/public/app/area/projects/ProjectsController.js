function ProjectsController(ProjectsResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    this.init();
}

ProjectsController.prototype.init = function() {
    var self = this;
    self.ProjectsResource.projects.getAll({}, function(data) {
        self.projects = data;
    });
};

ProjectsController.prototype.editProject = function(index) {
    console.log('index: ' + index);
    this.$location.path('projects/project_edit');
};

angular.module('spwizzard').controller('ProjectsController', ProjectsController);