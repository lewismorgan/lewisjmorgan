package com.lewismorgan.web.bootstrap.components.nav

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.nav

interface NavbarProps : RProps {
  var defaultActiveIndex: Int
  var navbarStyle: String
}

interface NavbarState : RState

/**
 * Created by lewis on 6/23/18.
 */
class NavbarComponent(props: NavbarProps) : RComponent<NavbarProps, NavbarState>(props) {
  override fun RBuilder.render() {
    nav("navbar ${props.navbarStyle}") {
      children()
    }
  }
}

fun RBuilder.navbar(navbarStyle: String, defaultActiveIndex: Int, block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarProps, NavbarComponent> {
    attrs.navbarStyle = navbarStyle
    attrs.defaultActiveIndex = defaultActiveIndex
    block()
  }
}