package com.lewismorgan.web


import com.lewismorgan.web.bootstrap.nav.navComponent
import com.lewismorgan.web.bootstrap.nav.navbar
import com.lewismorgan.web.bootstrap.nav.navbarBranding
import com.lewismorgan.web.bootstrap.nav.navbarCollapsible
import com.lewismorgan.web.bootstrap.nav.navbarToggler
import com.lewismorgan.web.bootstrap.nav.navigationItem
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.span

class WebsiteNavbarComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    navbar("navbar-expand-lg navbar-dark fixed-top bg-dark", true) {
      div("container") {
        navbarBranding("#Home") {
          fontAwesome("map-marked-alt", FontAwesomeStyleType.SOLID)
        }
        navbarToggler { span("navbar-toggler-icon") {} }
        navbarCollapsible {
          navComponent {
            navigationItem("#Home", "Home") {
              // TODO Navigate to top of page
            }
            navigationItem("#Projects", "Projects") {
              // TODO Navigate to Projects
            }
            navigationItem("#Education", "Education") {
              // TODO Navigate to Education
            }
            navigationItem("#Contact", "Contact") {
              // TODO Navigate to Contact
            }
          }
        }
      }
    }
  }
}