package io.lewismorgan.app.bootstrap.carousel

import io.lewismorgan.app.bootstrap.dsl.container
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div

interface CarouselItemProps : RProps {
  var isActive: Boolean
  var classes: String
}

/**
 * Created by lewis on 6/16/18.
 */
class CarouselItemComponent : RComponent<CarouselItemProps, RState>() {
  override fun RBuilder.render() {
    @Suppress("SENSELESS_COMPARISON")
    div("carousel-item ${if (props.isActive) "active" else ""} ${if (props.classes != null) props.classes else ""}") {
      container {
        children()
      }
    }
  }
}

fun RBuilder.carouselItem(block: RBuilder.() -> Unit): ReactElement {
  return child<CarouselItemProps, CarouselItemComponent> {
    block()
  }
}

fun RBuilder.carouselCaption(classes: String, block: RBuilder.() -> Unit): ReactElement {
  return div("carousel-caption $classes") { block() }
}