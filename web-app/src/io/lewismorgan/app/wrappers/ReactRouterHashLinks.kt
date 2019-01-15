@file:JsModule("react-router-hash-link")

package io.lewismorgan.app.wrappers

import org.w3c.dom.Element
import org.w3c.dom.events.Event
import react.Component
import react.RProps
import react.RState

@JsName("NavHashLink")
external class NavHashLinkComponent : Component<NavHashLinkProps, RState> {
  override fun render(): dynamic
}

external interface NavHashLinkProps : RProps {
  var to: String
  var onClick: (Event) -> Unit
  var className: String?
  var activeClassName: String?
  var smooth: Boolean
  var scroll: (Element) -> Unit
}
