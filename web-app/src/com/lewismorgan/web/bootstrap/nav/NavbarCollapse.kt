package com.lewismorgan.web.bootstrap.nav


import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div

interface NavbarCollapseProps : RProps {
  var collapsed: Boolean
}

interface NavbarCollapseState : RState {
  var collapsed: Boolean
}

class NavbarCollapse(props: NavbarCollapseProps) : RComponent<NavbarCollapseProps, NavbarCollapseState>(props) {
  override fun NavbarCollapseState.init(props: NavbarCollapseProps) {
    collapsed = props.collapsed
  }

  override fun RBuilder.render() {
    // TODO : Add "show" class when toggle collapse state, transition with "collapsing"
    div("navbar-collapse collapse") {
      children()
    }
  }
}
fun RBuilder.navbarCollapse(block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarCollapseProps, NavbarCollapse> {
    attrs.collapsed = true
    block()
  }
}
