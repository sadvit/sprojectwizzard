function LoginController(UsersResource, $location, $cookieStore) {
    Object.defineProperty(this, 'location', { writable: true, value: $location });
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    this.init();
}

/**
 * Вход осуществляется следующим образом:
 * 1. Отправляется запрос login/pass
 * 2. Если возвращается обьект User - OK, сохраняем его в cookies и перенаправляемся в projects
 * 3. Если не возвращается - введен неправильный логин / пароль.
 */
LoginController.prototype.init = function() {

};

LoginController.prototype.auth = function(login, pass) {
    var self = this;
    self.UsersResource.auth({login: login, pass: pass}, function(user) {
        if (user.id != undefined) {
            self.cookies.user = user;
            self.location.path('projects');
        } else {
            /*TODO вывести табличку "неверный логин/пароль"*/
        }
    });
};

angular.module('spwizzard').controller('LoginController', LoginController);
