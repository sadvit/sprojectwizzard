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
        'delete' : {
            url: '/users/:id',
            params: {
                id: '@id'
            },
            method: 'DELETE'
        },
        'save' : {
            url: '/users/',
            method: 'POST'
        },
        'update' : {
            url: '/users/',
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