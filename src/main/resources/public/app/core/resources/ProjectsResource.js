angular.module('spwizzard').factory('ProjectsResource', function($resource) {
    return {
        'projects' : $resource('/projects', {}, {
            'getAll': {
                url: '/projects',
                method: 'GET',
                isArray: true
            }
        })
    };
});

