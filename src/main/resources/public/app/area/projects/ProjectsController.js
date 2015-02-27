function ProjectsController(ProjectsResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'resource', { writable: true, value: ProjectsResource });
    this.init();
}

ProjectsController.prototype.init = function() {
    var self = this;
    self.resource.loadAll({}, function(data) {
        self.projects = data;
    });
};

ProjectsController.prototype.editProject = function(index) {
    console.log('index: ' + index);
    this.$location.path('projects/project_edit');
};

ProjectsController.prototype.createProject = function() {

};

angular.module('spwizzard').controller('ProjectsController', ProjectsController);