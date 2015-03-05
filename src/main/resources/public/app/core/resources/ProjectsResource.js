angular.module('spwizzard').factory('ProjectsResource', function($resource) {
    return $resource('/projects/', {}, {
        'loadAll': {
            url: '/projects',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/projects/:id',
            method: 'GET'
        },
        'loadContacts' : {
            url: '/projects/contacts/:id',
            method: 'GET'
        },
        'loadTeamShort' : {
            url: '/projects/team/short/:id',
            method: 'GET'
        },
        'loadTeamFull' : {
            url: '/projects/team/full/:id',
            method: 'GET'
        },
        'save' : {
            url: '/projects',
            method: 'POST'
        },
        'update' : {
            url: '/projects',
            method: 'PUT'
        },
        'delete': {
            url: '/projects/:id',
            method: 'DELETE'
        }
    });

});

