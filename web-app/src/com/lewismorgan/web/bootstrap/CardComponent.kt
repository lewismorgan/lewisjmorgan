package com.lewismorgan.web.bootstrap

import kotlinx.html.DIV
import react.dom.RDOMBuilder
import react.dom.div

fun RDOMBuilder<DIV>.card(block: RDOMBuilder<DIV>.() -> Unit) {
  div("card") {
    block()
  }
}

fun RDOMBuilder<DIV>.cardHeader(block: RDOMBuilder<DIV>.() -> Unit) {
  div("card-header") {
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