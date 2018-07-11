package com.lewismorgan.web.bootstrap.nav

import com.lewismorgan.web.misc.chainedFunction
import com.lewismorgan.web.misc.getChildren
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement
import react.dom.ul
import react.setState

interface NavProps : RProps {
  var defaultIndex: Int
  var onSelectItem: ((Int) -> (Event) -> Unit)?
}

interface NavState : RState {
  var activeIndex: Int
}

/**
 * Created by lewis on 6/23/18.
 */
class NavComponent : RComponent<NavProps, NavState>() {
  override fun NavState.init() {
    activeIndex = 0
  }

  override fun NavState.init(props: NavProps) {
    activeIndex = props.defaultIndex
  }

  override fun shouldComponentUpdate(nextProps: NavProps, nextState: NavState): Boolean {
    return nextProps.defaultIndex != props.defaultIndex || nextState.activeIndex != state.activeIndex
  }

  override fun RBuilder.render() {
    ul("navbar-nav") {
      val children = getChildren()
      if (children.isNotEmpty()) {
        for (i in 0 until children.size) {
          val activeChild = children[i]
          child(cloneElement<NavItemProps>(activeChild, activeChild.props.children, props = {
            isActive = state.activeIndex == i
            onSelect = if (props.onSelectItem != null) {
              chainedFunction(onSelectNavItem(i), props.onSelectItem!!(i))
            } else {
              onSelectNavItem(i)
            }
          }))
        }
      }
    }
  }

  private fun onSelectNavItem(index: Int): (Event) -> Unit = {
    console.log("NAV ITEM SELECTED")
    setState {
      activeIndex = index
    }
  }
}

fun RBuilder.navComponent(onSelectItem: ((Int) -> (Event) -> Unit)? = null, block: RBuilder.() -> Unit): ReactElement {
  return child<NavProps, NavComponent> {
    onSelectItem?.apply { attrs.onSelectItem = this }
    block()
  }
}