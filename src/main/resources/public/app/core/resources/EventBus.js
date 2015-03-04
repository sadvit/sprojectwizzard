// используется для отслеживаний евентов в дочерних контроллерах главным IndexController ом.
angular.module('spwizzard').factory('EventBus', function() {
    return {
        map: {},
        // имя регистрации и сам обьект
        // у обьекта должен быть реализован метод handleMessage(object)
        register: function(name, object) {
            this.map[name] = object; // регестрируем получателя
        },
        // имя получателя и сообщение
        send: function (name, message) {
            this.map[name].handleMessage(message);
        }
    }
});



