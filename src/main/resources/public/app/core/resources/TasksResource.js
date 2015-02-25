angular.module('spwizzard').factory('TasksResource', function($resource) {
    return $resource('/tasks', {}, {
        'getByProjectId' : {
            url: '/tasks/project/:projectId',
            method: 'GET',
            isArray: true
        }
    });
});

