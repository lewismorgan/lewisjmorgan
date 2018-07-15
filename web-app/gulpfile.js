var gulp = require('gulp');
var sass = require('gulp-sass');
var rename = require('gulp-rename');
var cleanCSS = require('gulp-clean-css');
var del = require('del');

const paths = {
  styles: {
    src: 'scss/**/*.scss',
    dest: 'src/stylesheets'
  }
};

function clean() {
  return del(['src/stylesheets']);
}

function styles() {
  return gulp.src(paths.styles.src)
    .pipe(sass())
    .pipe(gulp.dest(paths.styles.dest));
}

function watch() {
  gulp.watch(paths.styles.src, styles);
}

gulp.task('clean', clean);
gulp.task('styles', styles);
gulp.task('watch', watch);

var build = gulp.series(clean, styles);
gulp.task('build', build);
gulp.task('default', build);