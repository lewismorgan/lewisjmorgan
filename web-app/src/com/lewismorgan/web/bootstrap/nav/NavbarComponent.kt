package com.lewismorgan.web.bootstrap.nav

import kotlinx.html.classes
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.nav
import react.setState
import kotlin.browser.window

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