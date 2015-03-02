function ProjectsEditController(ProjectsResource, $routeParams, $cookieStore, RequirementsResource, TeamsResource) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });
    Object.defineProperty(this, 'TeamsResource', { writable: true, value: TeamsResource });

    this.projectId = this.$routeParams.id;
    this.projectCreation = this.projectId === undefined;

    this.init();
}

// TODO получить контактные данные менеджера - создателя
ProjectsEditController.prototype.init = function() {
    var self = this;

    self.TeamsResource.loadAll(function (data) {
        console.log('TEAMS: ' + JSON.stringify(data));
        self.teams = data;
        if(self.projectCreation) {
            self.project = {};
            self.project.team = data[0];
        }
    });

    if (!self.projectCreation) {
        self.action = "Обновить";
        self.ProjectsResource.load({
            id: self.projectId
        }, function (data) {
            self.project = data;
        });
    } else {
        self.action = "Создать";
    }
};

ProjectsEditController.prototype.saveProject = function() {
    var self = this;
    if (!self.projectCreation) {
        self.ProjectsResource.update(self.project, function() {
            console.log('Project updated')
        })
    } else {
        self.ProjectsResource.save(self.project, function() {
            console.log('Project saved')
        })
    }
};

ProjectsEditController.prototype.deleteProject = function() {
    var self = this;
    if(confirm('Rly??')) {
        self.ProjectsResource.delete({
            id: self.projectId
        }, function() {
            console.log('Project deleted');
            self.$location.path('projects');
        });
    }
};

angular.module('spwizzard').controller('ProjectsEditController', ProjectsEditController);