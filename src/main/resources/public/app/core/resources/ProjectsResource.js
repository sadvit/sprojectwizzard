angular.module('spwizzard').factory('ProjectsResource', function($resource) {
    return $resource('/projects/', {}, {
        'loadAll': {
            url: '/projects/',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/project/:id',
            params: {
                id: '@id'
            },
            method: 'GET'
        },
        'save' : {
            url: '/project/',
            params: {
                project: '@project'
            },
            method: 'PUT'
        }
    });

});

