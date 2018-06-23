package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.components.carousel.carousel
import com.lewismorgan.web.bootstrap.components.carousel.carouselCaption
import com.lewismorgan.web.bootstrap.components.carousel.carouselItem
import com.lewismorgan.web.bootstrap.components.nav.navComponent
import com.lewismorgan.web.bootstrap.components.nav.navbarBranding
import com.lewismorgan.web.bootstrap.components.nav.navbarCollapsible
import com.lewismorgan.web.bootstrap.components.nav.navbarToggler
import com.lewismorgan.web.bootstrap.components.nav.navbar
import com.lewismorgan.web.bootstrap.components.nav.navigationItem
import kotlinx.html.MAIN
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.h1
import react.dom.p
import react.dom.span
import react.dom.tag

class IndexAppComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    navbar("navbar-expand-md navbar-dark fixed-top bg-dark", 0) {
      navbarBranding("#Home") { +"Lewis' Temple" }
      navbarToggler { span("navbar-toggler-icon") {} }
      navbarCollapsible {
        navComponent {
          navigationItem("#Home", "Home") {
            console.log("Navigating home!")
          }
          navigationItem("#Projects", "Projects") {
            console.log("Projects page not implemented yet :[")
          }
          navigationItem("https://github.com/lewismorgan", "Code") {
            console.log("Navigating to GitHub.")
          }
          navigationItem("#Contact", "Contact") {
            console.log("Contact page not implemented yet :[")
          }
        }
      }
    }

    // the main contents for the page
    main("", "main") {
      carousel(0) {
        carouselItem {
          carouselCaption("text-left") {
            h1 { +"Welcome." }
            p { +"// TODO: Insert witty welcoming text here" }
          }
        }
        carouselItem {
          carouselCaption("") {
            h1 { +""""Do. Or do not. There is no try."""" }
            p { +"- Master Yoda (The Empire Strikes Back)" }
          }
        }
      }
    }
  }
}

inline fun RBuilder.main(classes: String? = null, role: String? = null, block: RDOMBuilder<MAIN>.() -> Unit): ReactElement = tag(block) { MAIN(attributesMapOf("class", classes, "role", role), it) }