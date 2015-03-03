// -1 - скрывать, 0 - чтение, 1 - запись
angular.module('spwizzard').factory('Session', function($cookieStore) {
    // права по умолчанию
    var rights = {
        projects:       -1,
        tasks:          -1,
        employees:      -1,
        requirements:   -1,
        users:          -1,
        profile:        -1,
        exit:           -1
    };

    console.log('WQEQWE ' + $cookieStore.user);
    if ($cookieStore.user == undefined) {
        return rights;
    }

    var role;
    if ($cookieStore.user.employee != undefined) {
        role = $cookieStore.user.employee.role;
    } else {
        role = 'MANAGER';
    }

    switch (role) {
        case 'ADMIN':
            rights.users    = 1;
            rights.exit     = 0;
            break;
        case 'PROGRAMMER':
            rights.projects     = 0;
            rights.tasks        = 0;
            rights.employees    = 0;
            rights.requirements = 0;
            rights.profile      = 0;
            rights.exit         = 0;
            break;
        case 'LEADER':
            rights.projects     = 0;
            rights.tasks        = 1;
            rights.employees    = 0;
            rights.requirements = 0;
            rights.profile      = 0;
            rights.exit         = 0;
            break;
        case 'ANALYST':
            rights.projects     = 0;
            rights.tasks        = 1;
            rights.employees    = 0;
            rights.requirements = 1;
            rights.profile      = 0;
            rights.exit         = 0;
            break;
        case 'MANAGER':
            rights.projects     = 1;
            rights.tasks        = 0;
            rights.employees    = 1;
            rights.requirements = 0;
            rights.profile      = 0;
            rights.exit         = 0;
            break;
    }
    return rights;
});



