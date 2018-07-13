package com.lewismorgan.web.children

import com.lewismorgan.web.misc.getScrollTop
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div
import react.setState
import kotlin.browser.document
import kotlin.browser.window

interface FloatingItemProps : RProps {
  var classes: String
  var displayScrollOffset: Int
}

interface FloatingItemState : RState {
  var displayed: Boolean
}

class FloatingItemComponent(props: FloatingItemProps) : RComponent<FloatingItemProps, FloatingItemState>(props) {
  private val floatingItemScrollHandler: (Event) -> Unit = createFloatingScrollHandler()

  override fun shouldComponentUpdate(nextProps: FloatingItemProps, nextState: FloatingItemState): Boolean {
    return (nextState.displayed != state.displayed)
  }

  override fun componentWillMount() {
    window.addEventListener("scroll", floatingItemScrollHandler)
  }

  override fun componentWillUnmount() {
    window.removeEventListener("scroll", floatingItemScrollHandler)
  }

  private fun createFloatingScrollHandler(): (Event) -> Unit = {
    val scrollTop = getScrollTop(document)
    val winHeight = window.innerHeight
    val docHeight = document.documentElement!!.scrollHeight

    if ((((scrollTop) / (docHeight - winHeight)) * 100) >= props.displayScrollOffset) {
      setState {
        displayed = true
      }
    } else {
      setState {
        displayed = false
      }
    }
  }

  override fun RBuilder.render() {
    div("floating-item ${if (state.displayed) "floating-item-shown" else "floating-item-hidden"} ${props.classes}") {
      children()
    }
  }
}

fun RBuilder.floatingItem(handler: RHandler<FloatingItemProps>): ReactElement =
    child<FloatingItemProps, FloatingItemComponent>(handler)