function ProjectsEditController(ProjectsResource, $routeParams, $cookieStore) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    this.projectId = this.$routeParams.id;
    this.isUpdate = this.projectId !== undefined;
    this.init();
    console.log('iiiidd' + this.isUpdate);
}

// TODO получить контактные данные менеджера - создателя
ProjectsEditController.prototype.init = function() {
    var self = this;
    if (self.isUpdate) {
        self.ProjectsResource.load({id: self.projectId}, function (project) {
            console.log('user: ' + project);
            self.project = project;
        });
    } else {
        self.project = {};
    }
};

ProjectsEditController.prototype.saveProject = function() {
    var self = this;
    if (self.isUpdate) {
        self.ProjectsResource.update(self.project, function() {
            console.log('update')
        })
    } else {
        self.ProjectsResource.save(self.project, function() {
            console.log('saved')
        })
    }
};

ProjectsEditController.prototype.deleteProject = function() {

};

angular.module('spwizzard').controller('ProjectsEditController', ProjectsEditController);