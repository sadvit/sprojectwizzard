angular.module('spwizzard', ['ngRoute', 'ngResource', 'ng-breadcrumbs', 'ngCookies']);

// TODO если будет нужно - прикрутить нормальную авторизацию как тут
// http://www.jonsamwell.com/url-route-authorization-and-security-in-angular/
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
        .when('/:pagename/:editname/:id', {
            templateUrl: function(urlattr) {
                return 'app/area/' + urlattr.pagename + '/' + urlattr.editname + '/temp.html';
            }
        })
        .otherwise({
            redirectTo: '/login'
        });
});