package com.lewismorgan.web.bootstrap.components.carousel

import com.lewismorgan.web.misc.jsIsArray
import kotlinx.html.A
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.li
import react.dom.ol
import react.dom.span
import react.dom.tag

interface CarouselProps : RProps {
  var defaultActiveIndex: Int
}

interface CarouselState : RState {
  var activeIndex: Int
}

class CarouselComponent(props: CarouselProps) : RComponent<CarouselProps, CarouselState>(props) {
  override fun CarouselState.init(props: CarouselProps) {
    activeIndex = props.defaultActiveIndex
  }

  override fun shouldComponentUpdate(nextProps: CarouselProps, nextState: CarouselState): Boolean {
    return (nextState.activeIndex != state.activeIndex || nextProps.defaultActiveIndex != state.activeIndex)
  }

  override fun RBuilder.render() {
    val children = getChildren()
    div("carousel slide") {
      // TODO Recreate indicators on state change
      if (children.isNotEmpty()) {
        ol("carousel-indicators") {
          for (i in 0 until children.size) {
            li(if (i == state.activeIndex) "active" else "") { }
          }
        }
      }
      if (children.isNotEmpty()) {
        div("carousel-inner") {
          for (i in 0 until children.size) {
            // ReactElements are immutable, so gotta clone
            val toClone = children[i]
            child(cloneElement<CarouselItemProps>(toClone, toClone.props.children, props = {
              this.isActive = (state.activeIndex == i)
            }))
          }
        }
      }

      // TODO Onclick go to previous item by changing state's index to -1
      carouselButton("carousel-control-prev") {
        span("carousel-control-prev-icon") {}
      }
      // TODO Onclick go to next item by changing states index to +1
      carouselButton("carousel-control-next") {
        span("carousel-control-next-icon") {}
      }
    }
  }

  private fun getChildren(): Array<ReactElement> {
    return if (jsIsArray(props.children)) {
      props.children.unsafeCast<Array<ReactElement>>()
    } else {
      arrayOf(props.children.unsafeCast<ReactElement>())
    }
  }
}

private inline fun RBuilder.carouselButton(classes: String? = null, block: RDOMBuilder<A>.() -> Unit): ReactElement = tag(block) {
  A(attributesMapOf("class", classes,
      "role", "button"
  ), it)
}

fun RBuilder.carousel(defaultActiveIndex: Int, block: RBuilder.() -> Unit): ReactElement {
  return child<CarouselProps, CarouselComponent> {
    attrs.defaultActiveIndex = defaultActiveIndex
    block()
  }
}
