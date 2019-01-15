/* Deletes the build folder if it exists, or any folders that match passed args */
'use strict'
const del = require('del')

var args = process.argv.slice(2)

const folders = ['build']

function clean(folder) {
  console.log("Cleaning folder", folder)
  del(folder)
}

if (args.length != 0) {
  args.forEach(clean)
} else {
  folders.forEach(clean)
}

