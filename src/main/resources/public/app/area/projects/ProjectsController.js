function ProjectsController(ProjectsResource, $location) {
    Object.defineProperty(this, '$location', { writable: true, value: $location });
    Object.defineProperty(this, 'resource', { writable: true, value: ProjectsResource });
    this.init();
}

ProjectsController.prototype.init = function() {
    var self = this;
    self.resource.loadAll({}, function(data) {
        console.log("data: " + data[0].id + ' ' + data[0].name);
        self.resource.save({project: data[0]}, function() {
            console.log('save');
        });
        //self.projects = data;
    });
};

ProjectsController.prototype.editProject = function(index) {
    console.log('index: ' + index);
    this.$location.path('projects/project_edit');
};

Projectscontroller.prototype.createProject = function() {

};

angular.module('spwizzard').controller('ProjectsController', ProjectsController);