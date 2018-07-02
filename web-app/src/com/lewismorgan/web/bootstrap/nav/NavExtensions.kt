package com.lewismorgan.web.bootstrap.nav

import react.RBuilder
import react.dom.a

inline fun RBuilder.navbarBranding(href: String, block: RBuilder.() -> Unit) {
  a(classes = "navbar-brand") {
    attrs.href = href
    block()
  }
}
