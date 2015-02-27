angular.module('spwizzard').factory('RequirementsResource', function($resource) {
    return $resource('/requirements', {}, {
        'loadAllForProject': {
            url: '/requirements/project/:projectId',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/requirements/:id',
            method: 'GET'
        },
        'save' : {
            url: '/requirements',
            method: 'POST'
        },
        'update' : {
            url: '/requirements',
            method: 'PUT'
        }
    });

});