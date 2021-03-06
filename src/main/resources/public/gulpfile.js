var gulp = require('gulp');
var gulpsync = require('gulp-sync')(gulp);
var bowerFiles = require('main-bower-files');
var bower = require('gulp-bower');
var filter = require('gulp-filter');
var concat = require('gulp-concat-util');
var uglify = require('gulp-uglify');
var plumber = require('gulp-plumber');
var sourcemaps = require('gulp-sourcemaps');
var watch = require('gulp-watch');
var sass = require('gulp-sass');

var output = 'assets/lib/';
var ourScriptsPath = ['app/core/app.js', 'app/core/resources/*.js', 'app/**/*.js'];

gulp.task('bower-install', function() {
    return bower()
        .pipe(gulp.dest('/bower_components'))
});

gulp.task('bower-scripts', function() {
    return gulp.src(bowerFiles())
        .pipe(filter(['*.js']))
        .pipe(uglify())
        .pipe(concat('bower-scripts.js'))
        .pipe(gulp.dest(output));
});

gulp.task('our-scripts', function() {
    return gulp.src(ourScriptsPath)
        .pipe(plumber())
        .pipe(sourcemaps.init())
        .pipe(concat('our-scripts.js'))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(output));
});

gulp.task('scss', function () {
    gulp.src('assets/scss/main.scss')
        .pipe(sass())
        .pipe(gulp.dest('assets/css'));
});

gulp.task('watch_scss', function() {
    gulp.watch(['assets/scss/main.scss'], ['scss'])
});

gulp.task('watch', function() {
    gulp.watch(ourScriptsPath, ['our-scripts'])
});

gulp.task('watch-all', function() {
    gulp.start('watch', 'watch_scss');
});

gulp.task('default', gulpsync.sync(['bower-install', 'bower-scripts', 'our-scripts']));