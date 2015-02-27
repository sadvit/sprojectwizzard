angular.module('spwizzard').factory('TasksResource', function($resource) {
    return $resource('/tasks', {}, {
        'getByProjectId' : {
            url: '/tasks/project/:projectId',
            method: 'GET',
            isArray: true
        },
        'save' : {
            url: '/tasks',
            method: 'POST'
        },
        'getById': {
            url: '/tasks/:id',
            method: 'GET'
        }
    });
});

