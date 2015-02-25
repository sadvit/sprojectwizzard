angular.module('spwizzard').factory('ProjectsResource', function($resource) {
    return {
        'projects' : $resource('/all_projects', {}, {
            'getAll': {
                url: '/all_projects',
                method: 'GET',
                isArray: true
            }
        })
    };
});

