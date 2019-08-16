This project was bootstrapped with [Create React Kotlin App](https://github.com/JetBrains/create-react-kotlin-app).

[![Netlify Status](https://api.netlify.com/api/v1/badges/498a9851-2ba6-4738-b83c-d4e016fc6f47/deploy-status)](https://app.netlify.com/sites/lewisjmorgan/deploys)

This folder contains all the necessary files in order to serve the frontend website. Since there is no backend (as of yet), it is easy to play around with it yourself. The goal for this web application is to demonstrate my experience and learn more about modern web technologies and Kotlin.

## Website Locations

* develop - Development react build published to [https://develop.lewismorgan.io](https://develop.lewismorgan.io)
* preview - Production react build published to [https://preview.lewismorgan.io](https://preview.lewismorgan.io)
* master - Live version of the site at [https://lewismorgan.io](https://lewismorgan.io) or [https://lewismorgan.dev](https://lewismorgan.dev)

By splitting between a development and preview branch, I'm able to test out a full production build before it's merged to master.

Pull requests are always development builds, since those will be merged into develop.

## Folder Structure

Because the web application is bootstrapped with create-react-kotlin-app, there is no need for any custom webpack processes since it's handled by the kotlin webpack scripts. The same limitations apply:
* public - Any static content to be served I put here, like the favicon, index, manifests, etc.
* src - All Kotlin files are kept inside here. I avoid putting anything else but kotlin files because I want to use gulp to handle the 'extra stuff'. Otherwise I would need to eject if I want to customize the Kotlin Webpack for stuff like pre-processors and uglify.
* scss - All Sass files are input here instead of the src folder, otherwise Kotlin Webpack would try to serve all the scss files. Having a top-level directory defeats needing to eject and modify webpack scripts while retaining all the functionality of create-react-kotlin-app.

### Source Folder Structure
As mentioned, I'm keeping **only** Kotlin classes within the src folder, similar to how there is a direct distinction in standard Java and Kotlin server applications with a resources folder. Here's the package breakdown:
* com/lewismorgan/web - Topmost package for components, root contains the sections
  * bootstrap - Components that are wrapping the bootstrap CSS classes, similar to what react-bootstrap module does except in Kotlin that can be used properly in React. Only Bootstrap components that I use/used have a React implementation.
  * children - Any subcompontents that are necessary for the website to function that are not "pages"
  * misc - Utility classes like extensions that I am too lazy to put somewhere else/couldn't find somewhere else to put them
  * wrappers - Kotlin DSL's and classes that wrap an external JavaScript library like react-router-hash-links. Naming convention follows the name of the node module, with Dsl if necessary.
* index - Required and used by create-react-kotlin-app for injecting JavaScript into the index.

## Available Scripts

Once the installation is done, you can run some commands inside the project folder:

### `npm start` or `yarn start`

Runs the app in development mode.
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload automatically when you make edits. This will NOT listen for Sass changes, another process must be run.

You will see build errors and lint warnings in the console.

### `npm run build` or `yarn build`

Builds the app for production to the `build` folder.<br>
It ensures that React is bundled in production mode and the build is optimized for best performance.

The build is minified and the filenames include hashes for cache management.

### `gulp`

Cleans and builds the application's CSS, minifying the final CSS from Sass.

### `gulp watch`

Watches the scss folder for any changes, use for development on the stylesheets with a local server from npm.

### `gulp clean`

Deletes src/stylesheets folder

### `gulp styles`

Compiles Sass stylesheets in scss into src/stylesheets

## License
All rights reserved to Lewis Morgan unless otherwise required.
