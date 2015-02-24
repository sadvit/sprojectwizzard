angular.module('spwizzard', ['ngRoute', 'ngResource', 'ng-breadcrumbs']);

angular.module('spwizzard').config(function($routeProvider) {
    $routeProvider
        .when('/:pagename', {
            templateUrl: function(urlattr) {
                return 'app/area/' + urlattr.pagename + '/temp.html';
            }
        })
        .when('/:pagename/:editname', {
            templateUrl: function(urlattr) {
                return 'app/area/' + urlattr.pagename + '/' + urlattr.editname + '/temp.html';
            }
        })
        .otherwise({
            redirectTo: '/'
        });
});