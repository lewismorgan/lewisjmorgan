package index

import com.lewismorgan.web.app.app
import com.lewismorgan.web.github.githubApp
import kotlinext.js.*
import react.dom.*
import kotlin.browser.*
import react.dom.render
import kotlin.browser.document

fun main(args: Array<String>) {
  requireAll(require.context("src", true, js("/\\.css$/")))
  render(document.getElementById("root")) {
    app()
    githubApp()
  }
}
