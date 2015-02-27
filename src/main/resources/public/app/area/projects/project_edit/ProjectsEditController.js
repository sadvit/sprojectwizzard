function ProjectsEditController(ProjectsResource, $routeParams, $cookieStore) {
    Object.defineProperty(this, '$routeParams', { writable: true, value: $routeParams });
    Object.defineProperty(this, 'ProjectsResource', { writable: true, value: ProjectsResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    this.init();
}

/**
 * Получить контактные данные менеджера... где их хранить?
 */
ProjectsEditController.prototype.init = function() {
    var self = this;
};

ProjectsEditController.prototype.saveProject = function() {
    var self = this;

};

ProjectsEditController.prototype.deleteProject = function() {
    var self = this;

};

angular.module('spwizzard').controller('ProjectsEditController', ProjectsEditController);