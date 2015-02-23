var app = angular.module('spwizzard');

app.factory('projects', function($resource){
    return $resource('/projects');
});

app.controller('controller', function($scope, $location, projects) {
    projects.query().$promise.then(function(result) {
        $scope.projects = result;
        console.log(result);
    });
    $scope.editProject = function() {
        $location.path('/projects/project_edit');
    }
});