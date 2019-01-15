package io.lewismorgan.app.bootstrap.nav

import kotlinx.html.role
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.nav

interface NavbarProps : RProps {
  var navbarStyle: String
}

/**
 * Created by lewis on 6/23/18.
 */
class NavbarComponent(props: NavbarProps) : RComponent<NavbarProps, RState>(props) {
  override fun RBuilder.render() {
    nav("navbar ${props.navbarStyle}") {
      attrs.role = "navigation"
      children()
    }
  }
}

fun RBuilder.navbar(navbarStyle: String, block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarProps, NavbarComponent> {
    attrs.navbarStyle = navbarStyle
    block()
  }
}