angular.module('spwizzard').factory('TeamsResource', function($resource) {
    return $resource('/teams', {}, {
        'save' : {
            url: '/teams',
            method: 'POST'
        },
        'loadAll' : {
            url: '/teams',
            method: 'GET',
            isArray: true
        },
        // загружает работников для id команды
        'loadEmployees' : {
            url: '/teams/:id/employees',
            method: 'GET',
            isArray: true
        },
        'loadUsers' : {
            url: '/teams/:id/users',
            method: 'GET',
            isArray: true
        }
    });
});