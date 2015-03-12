function LinksController(breadcrumbs) {
    Object.defineProperty(this, 'breadcrumbs', { writable: true, value: breadcrumbs });
}

LinksController.prototype.getLinkName = function(str) {
    switch (str) {
        case 'projects': return 'Проекты';
        case 'employees': return 'Работники';
        case 'roles': return 'Роли';
        case 'users': return 'Пользователи';
        case 'tasks': return 'Задачи';
        case 'requirements': return 'Требования';
        case 'profile': return 'Профиль';
        case 'requirements_edit': return 'Редактировать требование';
        case 'employees_edit': return 'Редактирование команды';
        case 'tasks_edit': return 'Редактирование задачи';
        case 'user_categories': return 'Пользовательские категории';
        case 'project_edit': return 'Редактирование проекта';
        case 'users_edit': return 'Редактирование пользователя';
    }
};

angular.module('spwizzard').controller('LinksController', LinksController);