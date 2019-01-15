var gulp = require('gulp');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');
var del = require('del');

const paths = {
  sass: {
    src: 'stylesheets/**/*.scss',
    dest: 'public/css'
  }
};

const options = {
  sass: {
    errLogToConsole: true,
    outputStyle: 'expanded'
  }
};

// Development build cycle for Sass files
function sassBuild() {
  return gulp.src(paths.sass.src)
    .pipe(sourcemaps.init())
    .pipe(sass(options.sass).on('error', sass.logError))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest(paths.sass.dest));
}

// Release cycle for Sass processing
function sassRelease() {
  return gulp.src(paths.sass.src)
    .pipe(sass({outputStyle: 'compressed'}))
    .pipe(gulp.dest(paths.sass.dest));
}

function sassClean() {
  return del(paths.sass.dest);
}

function sassWatch() {
  gulp.watch(paths.sass.src, sass);
}

// Sass Specific Tasks

gulp.task('sass-clean', sassClean);
gulp.task('sass-build', sassBuild);
gulp.task('sass-watch', sassWatch);
gulp.task('sass-release', sassRelease);

// Core Tasks

gulp.task('watch', gulp.series('sass-watch'));
gulp.task('clean', gulp.series('sass-clean'));
gulp.task('release', gulp.series('sass-release'));

gulp.task('build', gulp.series('clean', 'sass-build'));
gulp.task('default', gulp.task('build'));