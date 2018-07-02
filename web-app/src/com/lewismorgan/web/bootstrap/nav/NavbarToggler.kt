package com.lewismorgan.web.bootstrap.nav

import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.createContext
import react.dom.button
import react.dom.span
import react.setState

interface NavbarTogglerProps : RProps {
  var onToggle: (Event) -> Unit
  var collapsed: Boolean
}

class NavbarToggler(props: NavbarTogglerProps) : RComponent<NavbarTogglerProps, RState>(props) {

  override fun RBuilder.render() {
    // TODO Remove "collapsed" class when button toggled
    // TODO Default state is to be collapsed
    button(classes = "navbar-toggler ${if (props.collapsed) "collapsed" else "collapsed"}", type = ButtonType.button) {
      //attrs.onClickFunction = props.onToggle
      span("navbar-toggler-icon") {}
      children()
    }
  }
}

fun RBuilder.navbarToggler(block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarTogglerProps, NavbarToggler> {
    block()
  }
}