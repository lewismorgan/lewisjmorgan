package io.lewismorgan.app

import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.bootstrap.dsl.footer
import io.lewismorgan.app.fragments.iconFont
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
        iconFont(brandIcon, "$name-icon social-icon-anim")
      }
    }
  }

  private fun RDOMBuilder<DIV>.renderSocial() {
    h4 {
      span { +"Social\t" }
      iconFont("comment-empty")
    }
    ul("list-inline") {
      renderSocialItem("twitter", "twitter-squared", "https://twitter.com/lewismorgan_01")
      renderSocialItem("github", "github-circled", "https://github.com/LewisMorgan")
    }
  }

  override fun RBuilder.render() {
    footer("text-center") {
      container {
        div("row justify-content-md-center") {
          div("col-md-6") {
            h4 { +"Location" }
            p {
              iconFont("direction")
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