package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.components.carousel.carousel
import com.lewismorgan.web.bootstrap.components.carousel.carouselCaption
import com.lewismorgan.web.bootstrap.components.carousel.carouselItem
import com.lewismorgan.web.bootstrap.components.navbar.NavBarComponent
import com.lewismorgan.web.bootstrap.components.navbar.navigationBar
import com.lewismorgan.web.bootstrap.components.navbar.navigationItem
import kotlinx.html.BUTTON
import kotlinx.html.MAIN
import kotlinx.html.attributesMapOf
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.h1
import react.dom.p
import react.dom.tag

class IndexAppComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    navigationBar("navbar-expand-md navbar-dark fixed-top bg-dark", "Temple of Lewis",
        0) {
      navigationItem("#Home", "Home") {
        console.log("Navigating home!")
      }
      navigationItem("#Projects", "Projects") {
        console.log("Projects page not implemented yet :[")
        // TODO Projects window displaying some cool github project stats
      }
      navigationItem("https://github.com/lewismorgan", "Code") {
        console.log("Navigating to GitHub.")
      }
      navigationItem("#Contact", "Contact") {
        console.log("Contact page not implemented yet :[")
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
inline fun RBuilder.navbarToggler(classes: String? = null, block: RDOMBuilder<BUTTON>.() -> Unit): ReactElement = tag(block) {
  BUTTON(attributesMapOf(
      "class", classes, "type", "button", "data-toggle", "collapse",
      "data-target", "#navbarCollapse", "aria-controls", "navbarCollapse", "aria-expanded", "false",
      "aria-label", "Toggle Nav"), it)
}
