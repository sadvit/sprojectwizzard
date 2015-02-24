function LinksController(breadcrumbs) {
    Object.defineProperty(this, 'breadcrumbs', { writable: true, value: breadcrumbs });
}

LinksController.prototype.getLinkName = function(str) {
    switch (str) {
        case 'projects': return 'Проекты';
        case 'employees': return 'Работники';
        case 'roles': return 'Роли';
        case 'users': return 'Пользователи';
        case 'project_edit': return 'Создание/редактирование проекта';
    }
};

angular.module('spwizzard').controller('LinksController', LinksController);