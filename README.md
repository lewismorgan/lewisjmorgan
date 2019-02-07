[![Netlify Status](https://api.netlify.com/api/v1/badges/498a9851-2ba6-4738-b83c-d4e016fc6f47/deploy-status)](https://app.netlify.com/sites/lewisjmorgan/deploys)

# lewisjmorgan

This repository contains all the source code for my website. Right now there is no backend, however it'll probably be done using AWS Lambdas & Netlify if it's required at some point for the site.

### Contents
* web-app - Frontend user experience for the website. It's a single React app written using pure Kotlin with a React framework using create-react-app and Bootstrap for CSS. Gulp is also used for build assistance (glyphs and sass mostly).
  * Please see the README inside web-app for more detailed information.

## Deploying
* Netlify is used for continous deployment of the website whenever the master branch is updated. It serves a built web app to lewisjmorgan.com.

## Tools/Technologies
* Kotlin
* React
* CSS with Sass & Bootstrap
* JavaScript
* HTML
* Gulp
* Continous Deployment (Netlify)