package com.lewismorgan.web.bootstrap.nav

import kotlinx.html.BUTTON
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div
import react.dom.tag

inline fun RBuilder.navbarBranding(href: String, block: RBuilder.() -> Unit) {
  a(classes = "navbar-brand") {
    attrs.href = href
    block()
  }
}

inline fun RBuilder.navbarCollapsible(block: RBuilder.() -> Unit) {
  div("collapse navbar-collapse") {
    block()
  }
}
