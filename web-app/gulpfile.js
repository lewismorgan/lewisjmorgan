var gulp = require('gulp');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');
var del = require('del');

const paths = {
  styles: {
    src: 'stylesheets/**/*.scss',
    dest: 'public/css'
  }
};

const sassOptions = {
  errLogToConsole: true,
  outputStyle: 'expanded'
};

function clean() {
  return del(paths.styles.dest);
}

function stylesheets() {
  return gulp.src(paths.styles.src)
    .pipe(sourcemaps.init())
    .pipe(sass(sassOptions).on('error', sass.logError))
    .pipe(sourcemaps.write())
    .pipe(gulp.dest(paths.styles.dest));
}

function watch() {
  gulp.watch(paths.styles.src, sass);
}

function prod() {
  return gulp.src(paths.styles.src)
    .pipe(sass({outputStyle: 'compressed'}))
    .pipe(gulp.dest(paths.styles.dest));
}

gulp.task('clean', clean);
gulp.task('sass', stylesheets);
gulp.task('watch', watch);
gulp.task('prod', prod);

var build = gulp.series(clean, stylesheets);
gulp.task('build', build);
gulp.task('default', build);