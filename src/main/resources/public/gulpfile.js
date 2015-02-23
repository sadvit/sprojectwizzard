var gulp = require('gulp');
var bower = require('main-bower-files');
var filter = require('gulp-filter');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');

gulp.task('default', function() {
    return gulp.src(bower())
        .pipe(filter(['*.js']))
        .pipe(uglify())
        .pipe(concat('main.js'))
        .pipe(gulp.dest('lib/'));
});