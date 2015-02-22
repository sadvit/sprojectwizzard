var app = angular.module('spwizzard', ['ngRoute']);

app.controller('headerController',['$scope','$location', function ($scope, $location) {
    $scope.go = function (path) {
        $location.path(path);
    }
}]);

app.config(function($routeProvider) {
    $routeProvider.when("/persons", {templateUrl: "template.html", controller: 'headerController'});
});
