package com.lewismorgan.web


import kotlinx.html.DIV
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.footer
import react.dom.h4
import react.dom.li
import react.dom.p
import react.dom.ul

class FooterComponent : RComponent<RProps, RState>() {
  private fun RDOMBuilder<DIV>.renderSocial() {
    h4 { +"Social" }
    ul("list-inline") {
      li("list-inline-item") {
        fontAwesome("facebook-square", FontAwesomeStyleType.BRAND, FontAwesomeSize.X2)
      }
      li("list-inline-item") {
        fontAwesome("twitter-square", FontAwesomeStyleType.BRAND, FontAwesomeSize.X2)
      }
      li("list-inline-item") {
        fontAwesome("linkedin", FontAwesomeStyleType.BRAND, FontAwesomeSize.X2)
      }
    }
  }

  override fun RBuilder.render() {
    footer("footer text-center") {
      div("container") {
        div("row justify-content-md-center") {
          div("col-md-6") {
            h4 { +"Location" }
            p { +"Tampa, Florida" }
          }
          div("col-md-6") {
            renderSocial()
          }
        }
      }
    }
  }
}