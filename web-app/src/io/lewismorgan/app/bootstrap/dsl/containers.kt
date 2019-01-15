package io.lewismorgan.app.bootstrap.dsl

import kotlinx.html.DIV
import kotlinx.html.FOOTER
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.footer

fun RBuilder.container(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit) {
  div(if (classes != null) "container $classes" else "container") {
    block()
  }
}

fun RBuilder.footer(classes: String? = null, block: RDOMBuilder<FOOTER>.() -> Unit) {
  footer(if (classes != null) "footer $classes" else "footer") {
    block()
  }
}