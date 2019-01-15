package io.lewismorgan.app.bootstrap.nav

import io.lewismorgan.app.misc.chainedFunction
import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.button
import react.dom.span
import react.setState

interface NavbarTogglerProps : RProps {
  var onToggle: (Event) -> Unit
  var collapsed: Boolean
}

interface NavbarTogglerState : RState {
  var collapsed: Boolean
}

class NavbarToggler(props: NavbarTogglerProps) : RComponent<NavbarTogglerProps, NavbarTogglerState>(props) {
  override fun NavbarTogglerState.init(props: NavbarTogglerProps) {
    collapsed = props.collapsed
  }

  override fun shouldComponentUpdate(nextProps: NavbarTogglerProps, nextState: NavbarTogglerState): Boolean {
    return nextProps.collapsed != props.collapsed || nextState.collapsed != state.collapsed || props.collapsed != state.collapsed
  }

  private fun collapseToggle(): (Event) -> Unit = {
    setState {
      collapsed = !collapsed
//      console.log("State set for toggler to $collapsed")
    }
  }

  override fun RBuilder.render() {
    button(classes = "navbar-toggler ${if (state.collapsed) "collapsed" else ""}", type = ButtonType.button) {
      attrs.onClickFunction = chainedFunction(collapseToggle(), props.onToggle)
      span("navbar-toggler-icon") {}
      children()
    }
  }
}

fun RBuilder.navbarToggler(collapsed: Boolean, onClick: (Event) -> Unit, block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarTogglerProps, NavbarToggler> {
    attrs.onToggle = onClick
    attrs.collapsed = collapsed
    block()
  }
}