package com.lewismorgan.web.wrappers

import org.w3c.dom.Element
import org.w3c.dom.events.Event
import react.RBuilder
import react.RHandler

fun RBuilder.navHashLink(to: String,
                         className: String? = null,
                         activeClassName: String = "active",
                         onClick: ((Event) -> Unit)? = null,
                         scroll: ((Element) -> Unit)? = null,
                         handler: RHandler<NavHashLinkProps>) = child<NavHashLinkProps, NavHashLinkComponent> {
  attrs {
    this.to = to
    this.className = className
    this.activeClassName = activeClassName
    this.smooth = true
    if (onClick != null)
      this.onClick = onClick
    if (scroll != null)
      this.scroll = scroll
  }
  handler.invoke(this)
}