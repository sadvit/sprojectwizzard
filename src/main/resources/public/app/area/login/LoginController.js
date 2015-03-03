function LoginController(UsersResource, $location, $cookieStore, Session) {
    Object.defineProperty(this, 'location', { writable: true, value: $location });
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    Object.defineProperty(this, 'session', { writable: true, value: Session });
    this.init();
}

LoginController.prototype.init = function() {
    this.isError = false;
};

/**
 * Вход осуществляется следующим образом:
 * 1. Отправляется запрос login/pass
 * 2. Если возвращается обьект User - OK, сохраняем его в cookies и перенаправляемся в projects
 * 3. Если не возвращается - введен неправильный логин / пароль.
 */
LoginController.prototype.auth = function(login, pass) {
    console.log('auth');
    var self = this;
    self.UsersResource.auth({login: login, pass: pass}, function(user) {
        if (user != undefined && user.id != undefined) {
            console.log('user: ' + JSON.stringify(user));
            self.cookies.user = user;
            self.location.path('projects');
        } else {
            self.isError = true;
        }
    });
};

/**
 * Выход осуществляется следующим образом:
 * 1. Стирается обьект user из cookies
 * 2. Перенаправление на страницу входа в систему.
 */
LoginController.prototype.exit = function() {
    this.cookies.user = undefined;
    this.$location.path('login');
};

angular.module('spwizzard').controller('LoginController', LoginController);