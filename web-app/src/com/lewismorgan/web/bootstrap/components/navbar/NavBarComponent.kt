package com.lewismorgan.web.bootstrap.components.navbar

import com.lewismorgan.web.misc.getChildren
import com.lewismorgan.web.navbarToggler
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement
import react.dom.a
import react.dom.div
import react.dom.li
import react.dom.nav
import react.dom.span
import react.dom.ul

interface NavBarProps : RProps {
  var defaultActiveIndex: Int
  var navbarStyle: String
  var branding: String
}

interface NavBarState : RState {
  var activeIndex: Int
}

/**
 * Created by lewis on 6/23/18.
 */
class NavBarComponent(props: NavBarProps) : RComponent<NavBarProps, NavBarState>(props) {
  override fun NavBarState.init(props: NavBarProps) {
    activeIndex = props.defaultActiveIndex
  }

  override fun RBuilder.render() {
    nav("navbar ${props.navbarStyle}") {
      a(classes = "navbar-brand", href = "#") { +props.branding }
      navbarToggler("navbar-toggler") {
        span("navbar-toggler-icon") {}
      }
      div("collapse navbar-collapse") {
        ul("navbar-nav mr-auto") {
          val children = getChildren()
          if (children.isNotEmpty()) {
            for (i in 0 until children.size) {
              val activeChild = children[i]
              child(cloneElement<NavItemProps>(activeChild, activeChild.props.children, props = {
                isActive = state.activeIndex == i
              }))
            }
          }
        }
      }
    }
  }
}

fun RBuilder.navigationBar(navbarStyle: String, branding: String, defaultActiveIndex: Int, block: RBuilder.() -> Unit): ReactElement {
  return child<NavBarProps, NavBarComponent> {
    attrs.navbarStyle = navbarStyle
    attrs.branding = branding
    attrs.defaultActiveIndex = defaultActiveIndex
    block()
  }
}