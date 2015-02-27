angular.module('spwizzard').factory('ProjectsResource', function($resource) {
    return $resource('/projects/', {}, {
        'loadAll': {
            url: '/projects',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/projects/:id',
            params: {
                id: '@id'
            },
            method: 'GET'
        },
        'save' : {
            url: '/projects',
            method: 'POST'
        },
        'update' : {
            url: '/projects',
            method: 'PUT'
        }
    });

});

