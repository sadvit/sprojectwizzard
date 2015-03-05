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
        'updateStatus' : {
            url: '/tasks/:id/status',
            method: 'PUT'
        },
        'delete': {
            url: '/tasks/:id',
            method: 'DELETE'
        },
        'loadTaskRequirement': {
            url: '/tasks/:id/requirement',
            method: 'GET'
        },
        'loadTaskEmployee': {
            url: '/tasks/:id/employee',
            method: 'GET'
        },
        'loadTaskUser': {
            url: '/tasks/:id/user',
            method: 'GET'
        }
    });
});

