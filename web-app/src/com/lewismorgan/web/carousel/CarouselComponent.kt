package com.lewismorgan.web.carousel

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.h1
import react.dom.li
import react.dom.ol
import react.dom.p
import react.dom.span
import react.dom.tag

class CarouselComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    div("carousel slide") {
      ol("carousel-indicators") {
        // TODO Active css is changed based on active item (RState)
        li("active") {}
        li {}
      }
      div("carousel-inner") {
        // TODO Active css is changed based on active item (RState)
        div("carousel-item active") {
          div("container") {
            div("carousel-caption text-left") {
              h1 { +"Welcome." }
              p { +"// TODO: Insert witty welcoming text here." }
            }
          }
        }
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

inline fun RBuilder.carouselButton(classes: String? = null, block: RDOMBuilder<A>.() -> Unit): ReactElement = tag(block) {
  A(attributesMapOf("class", classes,
      "role", "button"
  ), it)
}

