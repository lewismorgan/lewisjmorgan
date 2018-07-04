package com.lewismorgan.web.bootstrap.nav

import com.lewismorgan.web.misc.navHashLink
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.li

interface NavItemProps : RProps {
  var isActive: Boolean
  var href: String
  var text: String
  var onSelect: (Event) -> Unit
}

/**
 * Created by lewis on 6/23/18.
 */
class NavItemComponent : RComponent<NavItemProps, RState>() {
  override fun RBuilder.render() {
    li("nav-item ${if (props.isActive) "active" else ""}") {
      attrs.role = "presentation"
      navHashLink("/" + props.href, props.onSelect, className = "nav-link") {
        +props.text
      }
    }
  }
}

fun RBuilder.navigationItem(href: String, text: String): ReactElement {
  return child<NavItemProps, NavItemComponent> {
    attrs.href = href
    attrs.text = text
  }
}