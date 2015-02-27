angular.module('spwizzard').factory('UsersResource', function($resource) {
    return $resource('/users/', {}, {
        'loadAll': {
            url: '/users',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/users/:id',
            params: {
                id: '@id'
            },
            method: 'GET'
        },
        'save' : {
            url: '/users/',
            method: 'POST'
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