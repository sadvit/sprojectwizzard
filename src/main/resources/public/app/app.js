var app = angular.module('spwizzard', ['ngRoute', 'ngResource']);

/**
 * Динамический роутинг. К запрашиваемой ссылке прибавляет
 * return 'app/components/' + urlattr.pagename + '/temp.html';
 * Ресурсы располагаются соответственно
 * // TODO переделать URL pattern
 */
app.config(function($routeProvider) {
    $routeProvider
        .when('/:pagename', {
            templateUrl: function(urlattr) {
                return 'app/components/' + urlattr.pagename + '/temp.html';
            }
        })
        .when('/:pagename/:editname', {
            templateUrl: function(urlattr) {
                return 'app/components/' + urlattr.pagename + '/' + urlattr.editname + '/temp.html';
            }
        })
        .otherwise({
            redirectTo: '/'
        });
});

app.directive('ngFooter', function() {
    return { templateUrl: "app/components/footer.html" };
});

/**
 * Сервис для ссылок - строит специальный объект с цепочкой ссылок
 * 1. Проверяем, передано два объекта, или один.
 *
 */
app.factory('LinkService', function($location) {
    return function($location) {
        if (pagename != undefined && editname != undefined) {
            var main = createPageLink('/');
            var obj1 = createPageLink(pagename);
            var obj2 = createEditLink(editname);
            return main + '::' + obj1 + '::' + obj2; // потом все в div
        }
        if (pagename != undefined) {
            var main = createPageLink('/');
            var obj1 = createPageLink(pagename);
            return main + '::' + obj1; // потом все в div
        }
    }
});

createPageLink = function (pagename) {
    if (pagename == '/') return '<a href="Главная">/</a>';
    return '<a href=' + pagename + '>' + getPageName(pagename) + '</a>';
};

createEditLink = function (editname) {
    return 'getEditName(editname)';
};

getPageName = function (pagename) {
    switch (pagename) {
        case 'projects': return 'Проекты';
    }
};

getEditName = function (editname) {
    switch (editname) {
        case 'project_edit': return 'Создание/редактирование проекта';
    }
};

app.directive('ngLink', [function(LinkService) {

}]);
