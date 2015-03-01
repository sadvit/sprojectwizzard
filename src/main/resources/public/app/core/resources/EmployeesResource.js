angular.module('spwizzard').factory('EmployeesResource', function($resource) {
    return $resource('/employees/', {}, {
        'loadAll': {
            url: '/employees',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/employees/:id',
            params: {
                id: '@id'
            },
            method: 'GET'
        },
        'save' : {
            url: '/employees',
            method: 'POST'
        },
        'update' : {
            url: '/employees',
            method: 'PUT'
        },
        'loadLeaders' : {
            url: '/employees/leaders/notbusy',
            method: 'GET',
            isArray: true
        },
        'loadProgrammers' : {
            url: '/employees/programmers/notbusy',
            method: 'GET',
            isArray: true
        },
        'loadAnalysts' : {
            url: '/employees/analysts/notbusy',
            method: 'GET',
            isArray: true
        }
    });
});

