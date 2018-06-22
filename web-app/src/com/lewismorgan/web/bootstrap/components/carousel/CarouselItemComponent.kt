package com.lewismorgan.web.bootstrap.components.carousel

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div

interface CarouselItemState : RState {
  var isActive: Boolean
}

/**
 * Created by lewis on 6/16/18.
 */
class CarouselItemComponent : RComponent<RProps, CarouselItemState>() {
  // TODO State change on isActive being true/false
  override fun CarouselItemState.init() {
    isActive = true
  }

  override fun RBuilder.render() {
    div("carousel-item ${if (state.isActive) "active" else ""}") {
      div("container") {
        children()
      }
    }
  }
}

fun RBuilder.carouselItem(block: RBuilder.() -> Unit): ReactElement {
  return child<RProps, CarouselItemComponent> {
    block()
  }
}

fun RBuilder.carouselCaption(classes: String, block: RBuilder.() -> ReactElement): ReactElement {
  return div("carousel-caption $classes") { block() }
}