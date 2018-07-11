# lewisjmorgan

This repository contains all the source code for my website. Right now there is no backend, however it'll probably be done using AWS Lambdas & Netlify. Netlify only allows Go & JS functions so I'll need to compile to JavaScript from Kotlin similar to the frontend (no React overhead though!).

### Contents
* web-app - Frontend user experience for the website. It's a single React app written using pure Kotlin with a React framework using create-react-app and Bootstrap for CSS.
  * Please see the README inside web-app for more detailed information.

## Deploying
* Circle-CI is used for sending build checks to GitHub for commit statuses. 

* Netlify is used for continous deployment of the website whenever the master branch is updated. It serves a built web app to lewisjmorgan.com.

## Tools/Technologies
* Kotlin
* React
* CSS with Sass & Bootstrap
* JavaScript
* HTML
* Gulp
* Continous Integration (Circle CI)
* Continous Deployment (Netlify)