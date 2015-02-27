angular.module('spwizzard').factory('UsersResource', function($resource) {
    return $resource('/users/', {}, {
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
        },
        'auth' : {
            url: '/login/',
            params: {
                login: '@login',
                pass: '@pass'
            },
            method: 'GET'
        }
    });

});