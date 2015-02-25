angular.module('spwizzard').factory('ProjectsResource', function($resource) {
    return $resource('/projects', {}, {
        'loadAll': {
            url: '/all_projects',
            method: 'GET',
            isArray: true
        },
        'load' : {
            url: '/project',
            params: {
                id: '@id'
            },
            method: 'GET'
        },
        'save' : {
            url: '/project',
            params: {
                project: '@project'
            },
            method: 'PUT'
        }
    });
    /*return {
        'projects' : $resource('/all_projects', {}, {
            'getAll': {
                url: '/all_projects',
                method: 'GET',
                isArray: true
            }
        })
    };*/
});

