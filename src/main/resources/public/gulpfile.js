var gulp = require('gulp');
var bower = require('main-bower-files');
var filter = require('gulp-filter');
var concat = require('gulp-concat-util');
var uglify = require('gulp-uglify');
var sourcemaps = require('gulp-sourcemaps');
var plumber = require('gulp-plumber');

gulp.task('scripts', function() {
    return gulp.src(['app/**/*.js'])
        .pipe(plumber())
        .pipe(sourcemaps.init())
        //.pipe(concat.header('(function() {\n\'use strict\';\n'))
        //.pipe(concat.footer('\n})();\n'))
        .pipe(concat('main.js'))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('lib/'));
});

gulp.task('bower-scripts', function() {
    return gulp.src(['bower_components/**/*.js',
    'node_components/**/*.js'])
        .pipe(plumber())
        .pipe(sourcemaps.init())
        .pipe(concat('bower-main.js'))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('lib/'));
});

gulp.task('live', function() {
    gulp.watch('lib/**/*.js', ['scripts']);
    gulp.watch('bower_components/**/*.js', ['bower-scripts']);
    gulp.watch('node_modules/**/*.js', ['bower-scripts']);
});

gulp.task('default', ['scripts', 'bower-scripts', 'live']);
