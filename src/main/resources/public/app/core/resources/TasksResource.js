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
        'load': {
            url: '/tasks/:id',
            method: 'GET'
        },
        'update' : {
            url: '/tasks',
            method: 'PUT'
        },
        'delete': {
            url: '/tasks/:id',
            method: 'DELETE'
        }
    });
});

