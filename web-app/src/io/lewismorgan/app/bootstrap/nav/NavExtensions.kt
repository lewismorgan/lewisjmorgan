package io.lewismorgan.app.bootstrap.nav

import react.RBuilder
import react.dom.a

inline fun RBuilder.navbarBrand(href: String, block: RBuilder.() -> Unit) {
  a(classes = "navbar-brand") {
    attrs.href = href
    block()
  }
}
