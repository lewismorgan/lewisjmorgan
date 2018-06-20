package com.lewismorgan.web.bootstrap.components.carousel

import kotlinx.html.A
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.li
import react.dom.ol
import react.dom.span
import react.dom.tag

interface CarouselProps : RProps

class CarouselComponent : RComponent<CarouselProps, RState>() {
  override fun RBuilder.render() {
    div("carousel slide") {
      ol("carousel-indicators") {
        // TODO Add indicator for each carousel item component
        li("active") {}
      }
      div("carousel-inner") {
        children()
      }
      // TODO Onclick go to previous item
      carouselButton("carousel-control-prev") {
        span("carousel-control-prev-icon") {}
      }
      // TODO Onclick go to next item
      carouselButton("carousel-control-next") {
        span("carousel-control-next-icon") {}
      }
    }
  }
}

private inline fun RBuilder.carouselButton(classes: String? = null, block: RDOMBuilder<A>.() -> Unit): ReactElement = tag(block) {
  A(attributesMapOf("class", classes,
      "role", "button"
  ), it)
}

fun RBuilder.carousel(block: RBuilder.() -> ReactElement): ReactElement {
  return child<CarouselProps, CarouselComponent> { block() }
}
