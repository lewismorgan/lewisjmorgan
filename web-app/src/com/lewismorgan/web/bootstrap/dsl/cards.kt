package com.lewismorgan.web.bootstrap.dsl

import kotlinx.html.DIV
import kotlinx.html.classes
import react.dom.RDOMBuilder
import react.dom.div

fun RDOMBuilder<DIV>.card(block: RDOMBuilder<DIV>.() -> Unit) {
  div("card") {
    block()
  }
}

fun RDOMBuilder<DIV>.cardHeader(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit) {
  div {
    attrs.classes += "card-header"
    classes?.run { attrs.classes += this }
    block()
  }
}

fun RDOMBuilder<DIV>.cardBody(block: RDOMBuilder<DIV>.() -> Unit) {
  div("card-body") {
    block()
  }
}

fun RDOMBuilder<DIV>.cardFooter(block: RDOMBuilder<DIV>.() -> Unit) {
  div("card-footer") {
    block()
  }
}