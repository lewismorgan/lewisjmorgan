package index

import com.lewismorgan.web.indexAppComponent
import com.lewismorgan.web.github.githubApp
import kotlinext.js.*
import react.dom.render
import kotlin.browser.document

fun main(args: Array<String>) {
  requireAll(require.context("src", true, js("/\\.css$/")))
  render(document.getElementById("root")) {
    indexAppComponent()
    githubApp()
  }
}
