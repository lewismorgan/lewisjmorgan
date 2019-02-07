package index

import io.lewismorgan.app.WebsiteComponent
import kotlinext.js.require
import react.dom.render
import react.dom.script
import react.router.dom.browserRouter
import kotlin.browser.document

@Suppress("UnsafeCastFromDynamic")
fun main(args: Array<String>) {
  @Suppress("UnsafeCastFromDynamic")
  render(document.getElementById("root")) {
    browserRouter {
      child(WebsiteComponent::class) {}
    }
    script(src = "jquery/dist/jquery.slim.min.js") {}
    script(src = "popper.js/dist/popper.min.js") {}
    script(src = "bootstrap/dist/js/bootstrap.min.js") {}
  }
}
