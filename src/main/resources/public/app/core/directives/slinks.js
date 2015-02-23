angular.module('spwizzard').directive('slinks', function() {
    return {
        restrict: 'E',
        templateUrl: "app/area/links.html",
        controller: LinksController,
        controllerAs: 'linksController'
    };
});
