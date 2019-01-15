package io.lewismorgan.app.bootstrap.nav


import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div

interface NavbarCollapseProps : RProps {
  var shown: Boolean
}

class NavbarCollapse(props: NavbarCollapseProps) : RComponent<NavbarCollapseProps, RState>(props) {
  override fun shouldComponentUpdate(nextProps: NavbarCollapseProps, nextState: RState): Boolean {
    return nextProps.shown != props.shown
  }

  override fun RBuilder.render() {
    // TODO: Transition with "collapsing"
    div("navbar-collapse collapse ${if (props.shown) "show" else ""}") {
      children()
    }
  }
}

fun RBuilder.navbarCollapse(uncollapsed: Boolean, block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarCollapseProps, NavbarCollapse> {
    attrs.shown = uncollapsed
    block()
  }
}
