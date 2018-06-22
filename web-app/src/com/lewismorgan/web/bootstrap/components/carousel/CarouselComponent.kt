package com.lewismorgan.web.bootstrap.components.carousel

import kotlinx.html.A
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
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

  override fun componentWillMount() {
  }

  override fun shouldComponentUpdate(nextProps: CarouselProps, nextState: CarouselState): Boolean {
    return (nextState.activeIndex != state.activeIndex
        || nextProps.defaultActiveIndex != state.activeIndex)
  }

  override fun componentWillUpdate(nextProps: CarouselProps, nextState: CarouselState) {
    console.log("WILL UPDATE COMPONENT")
  }

  override fun RBuilder.render() {
    val children = getChildren()
    div("carousel slide") {
      // TODO Recreate indicators on state change
      if (children.isNotEmpty()) {
        ol("carousel-indicators") {
          console.log("Creating", children, "list items")
          for (i in 0 until children.size) {
            console.log("created a li")
            li("active") { }
          }
        }
      }
      if (children.isNotEmpty()) {
        div("carousel-inner") {
          children()
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
    console.log("children type:", jsTypeOf(props.children))
    return if (jsTypeOf(props.children) == "object") {
      arrayOf(props.children.unsafeCast<ReactElement>())
    } else props.children.unsafeCast<Array<ReactElement>>()
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
