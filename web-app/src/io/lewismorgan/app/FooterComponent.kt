package io.lewismorgan.app

import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.bootstrap.dsl.footer
import io.lewismorgan.app.fragments.FontAwesomeSize
import io.lewismorgan.app.fragments.FontAwesomeStyleType
import io.lewismorgan.app.fragments.fontAwesome
import kotlinx.html.DIV
import kotlinx.html.UL
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div
import react.dom.h4
import react.dom.li
import react.dom.p
import react.dom.span
import react.dom.ul

class FooterComponent : RComponent<RProps, RState>() {
  private fun RDOMBuilder<UL>.renderSocialItem(name: String, brandIcon: String = name, href: String = "") {
    li("list-inline-item social") {
      a(href) {
        fontAwesome(brandIcon, FontAwesomeStyleType.BRAND, FontAwesomeSize.X2, "$name-icon social-icon-anim")
      }
    }
  }

  private fun RDOMBuilder<DIV>.renderSocial() {
    h4 {
      span { +"Social\t" }
      fontAwesome("comment", FontAwesomeStyleType.REGULAR, FontAwesomeSize.XS, powerTransform = "up-6")
    }
    ul("list-inline") {
      renderSocialItem("facebook", "facebook-square", "https://www.facebook.com/lewis.morgan.14")
      renderSocialItem("twitter", "twitter-square", "https://twitter.com/TheLewisMorgan")
      renderSocialItem("linkedin", href = "https://www.linkedin.com/in/lewis-morgan-51b7a6167/")
    }
  }

  override fun RBuilder.render() {
    footer("text-center") {
      container {
        div("row justify-content-md-center") {
          div("col-md-6") {
            h4 { +"Location" }
            p {
              fontAwesome("location-arrow", FontAwesomeStyleType.SOLID, FontAwesomeSize.XS, powerTransform = "up-6")
              span { +"\tTampa, Florida" }
            }
          }
          div("col-md-6") {
            renderSocial()
          }
        }
      }
    }
  }
}