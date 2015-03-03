function LoginController(UsersResource, $location, $cookieStore, EventBus) {
    Object.defineProperty(this, 'location', { writable: true, value: $location });
    Object.defineProperty(this, 'UsersResource', { writable: true, value: UsersResource });
    Object.defineProperty(this, 'cookies', { writable: true, value: $cookieStore });
    Object.defineProperty(this, 'EventBus', { writable: true, value: EventBus });
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
            self.cookies.put('user', user);
            self.location.path('projects');
            self.EventBus.send('IndexController', 'do nothing my brother...');
        } else {
            self.isError = true;
        }
    });
};

angular.module('spwizzard').controller('LoginController', LoginController);