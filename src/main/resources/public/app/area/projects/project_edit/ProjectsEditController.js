function ProjectsEditController(ProjectsResource, $routeParams, $cookieStore, RequirementsResource, TeamsResource, Session) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    Object.defineProperty(this, 'RequirementsResource', { writable: true, value: RequirementsResource });
    Object.defineProperty(this, 'TeamsResource', { writable: true, value: TeamsResource });
    Object.defineProperty(this, 'session', { writable: true, value: Session });
    this.init();
}

// удаляются лишние поля, оставляются только id-ники
function clean(project) {
    var mId = project.manager.id;
    var tId = project.team.id;
    project.manager = {id: mId};
    project.team = {id: tId};
}

ProjectsEditController.prototype.loadProject = function(projectId) {
    var self = this;
    self.ProjectsResource.load({id: projectId}, function (project) {
        console.log('PROJECT LOADED: ' + JSON.stringify(project));
        self.project = project;

        self.ProjectsResource.loadContacts({id: projectId}, function (manager) {
            console.log('CONTACTS LOADED: ' + JSON.stringify(manager));
            self.project.manager = manager;
        });
        self.ProjectsResource.loadTeam({id: projectId}, function (team) {
            console.log('TEAM LOADED: ' + JSON.stringify(team));
            self.project.team = team;
        });
    });
};

ProjectsEditController.prototype.loadTeams = function() {
    var self = this;
    self.TeamsResource.loadAllShort(function(teams) {
        console.log('TEAMS LOADED: ' + JSON.stringify(teams));
        self.teams = teams;   // список всех команд в укороченном варианте
    });
};

ProjectsEditController.prototype.redirect = function() {
    this.$location.path('projects');
};

ProjectsEditController.prototype.init = function() {
    var self = this;

    self.projectId = self.$routeParams.id;

    self.isCreateMode = self.projectId === undefined;
    self.isAllowEdit = self.session().projects == 1;

    self.user = self.cookies.get('user');

    self.loadTeams();

    if (self.isCreateMode) {
        self.createMode();
    } else {
        if (self.isAllowEdit) {
            self.editMode();
        } else {
            self.viewMode();
        }
    }

};

/**
 * <MODES>
 */

ProjectsEditController.prototype.createMode = function() {
    var self = this;
    self.action = "Создать";
    self.project = {};
    self.project.manager = {};
    self.project.manager = self.user.manager;
    // загружать список команд
};

ProjectsEditController.prototype.editMode = function() {
    var self = this;
    self.action = "Редактировать";
    self.loadProject(self.projectId);
};

ProjectsEditController.prototype.viewMode = function() {
    var self = this;
    self.action = "Просмотреть";
    self.loadProject(self.projectId);
};

/**
 * </MODES>
 */

/**
 * <ACTIONS>
 */

ProjectsEditController.prototype.saveProject = function() {
    var self = this;
    clean(self.project);
    if (self.isCreateMode) {
        self.ProjectsResource.save(self.project, function() {
            console.log('PROJECT SAVED: ' + JSON.stringify(self.project));
            self.redirect();
        })
    } else {
        self.ProjectsResource.update(self.project, function() {
            console.log('PROJECT UPDATED: ' + JSON.stringify(self.project));
            self.redirect();
        })
    }
};

ProjectsEditController.prototype.deleteProject = function() {
    var self = this;
    self.ProjectsResource.delete({id: self.projectId}, function() {
        console.log('PROJECT DELETED ID: ' + self.projectId);
        self.redirect();
    });
};

/**
 * </ACTIONS>
 */

angular.module('spwizzard').controller('ProjectsEditController', ProjectsEditController);