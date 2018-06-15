package index

import com.lewismorgan.web.IndexAppComponent
import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.render
import react.dom.script
import kotlin.browser.document

fun main(args: Array<String>) {
  @Suppress("UnsafeCastFromDynamic")
  require("bootstrap/dist/css/bootstrap.min.css")
  requireAll(require.context("src", true, js("/\\.css$/")))
  render(document.getElementById("root")) {
    child(IndexAppComponent::class) {}
    script(src = "jquery/dist/jquery.js") {}
    script(src = "popper.js/dist/popper.js") {}
    script(src = "bootstrap/dist/js/bootstrap.min.js") {}
  }
}
