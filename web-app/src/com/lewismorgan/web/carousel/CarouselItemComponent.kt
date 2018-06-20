package com.lewismorgan.web.carousel

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div

interface CarouselItemProps : RProps {
  var active: Boolean
}

/**
 * Created by lewis on 6/16/18.
 */
class CarouselItemComponent : RComponent<CarouselItemProps, RState>() {
  override fun RBuilder.render() {
    div("carousel-item ${if (props.active) "active" else ""}") {
      children()
    }
  }
}

fun RBuilder.carouselItem(active: Boolean, block: RBuilder.() -> ReactElement): ReactElement {
  return child<CarouselItemProps, CarouselItemComponent> {
    attrs.active = active
    block()
  }
}