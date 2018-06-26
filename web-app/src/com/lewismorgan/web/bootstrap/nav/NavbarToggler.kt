package com.lewismorgan.web.bootstrap.nav

import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.button

interface NavbarTogglerProps : RProps {
  var onClick: (Event) -> Unit
}

class NavbarToggler : RComponent<NavbarTogglerProps, RState>() {
  override fun RBuilder.render() {
    button(classes = "navbar-toggler", type = ButtonType.button) {
      attrs["aria-controls"] = "navbarCollapse"
      attrs["aria-expanded"] = "false"
      attrs["aria-label"] = "Toggle Nav"
      attrs.onClickFunction = props.onClick
    }
  }
}

fun RBuilder.navbarToggler(onClick: (Event) -> Unit, block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarTogglerProps, NavbarToggler> {
    attrs.onClick = onClick
    block()
  }
}