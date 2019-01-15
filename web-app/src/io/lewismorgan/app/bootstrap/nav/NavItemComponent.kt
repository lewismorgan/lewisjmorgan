package io.lewismorgan.app.bootstrap.nav

import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.dom.li

interface NavItemProps : RProps {
  var isActive: Boolean
  var onSelect: (Event) -> Unit
}

/**
 * Created by lewis on 6/23/18.
 */
class NavItemComponent : RComponent<NavItemProps, RState>() {
  override fun RBuilder.render() {
    li("nav-item ${if (props.isActive) "active" else ""}") {
      attrs.role = "presentation"
      attrs.onClickFunction = props.onSelect
      children()
    }
  }
}

fun RBuilder.navigationItem(handler: RHandler<NavItemProps>): ReactElement = child<NavItemProps, NavItemComponent>(handler)