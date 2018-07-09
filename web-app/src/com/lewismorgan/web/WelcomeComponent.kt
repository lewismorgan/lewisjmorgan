package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.carousel.carousel
import com.lewismorgan.web.bootstrap.carousel.carouselCaption
import com.lewismorgan.web.bootstrap.carousel.carouselItem
import com.lewismorgan.web.bootstrap.dsl.container
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import react.dom.h2
import react.dom.i
import react.dom.p
import react.dom.section

/**
 * Created by lewis on 6/25/18.
 */
class WelcomeComponent : RComponent<RProps, RState>() {
  // TODO Move quotes into classes: IconImage, Text, Author, Movie (Optional)
  override fun RBuilder.render() {
    section {
      attrs["id"] = "sw-carousel"
      carousel(0) {
        swCarouselQuoteItem("swg-yoda-2") {
          h1 { +""""Do. Or do not. There is no try."""" }
          p { +"- Master Yoda (The Empire Strikes Back)" }
        }
        swCarouselQuoteItem("swg-k2s0") {
          h2 { +""""Half the people here wanna reprogram you...""" }
          h2 { +""" The other half wanna put a hole in your head."""" }
          p { +"- Jyn Erso" }
        }
        swCarouselQuoteItem("swg-c3po-2") {
          h2 { +""""Sir, the possibility of successfully navigating an asteroid field is approximately 3,720 to 1."""" }
          p { +"- C-3PO (The Empire Strikes Back)" }
        }
      }
    }
  }

  private fun RBuilder.swCarouselQuoteItem(swIcon: String, captionContent: RBuilder.() -> Unit) {
    carouselItem {
      container {
        i("swg $swIcon swg-6x carousel-icon-item") {}
        carouselCaption("") {
          captionContent()
        }
      }
    }
  }
}