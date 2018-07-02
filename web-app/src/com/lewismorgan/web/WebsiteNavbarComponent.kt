package com.lewismorgan.web


import com.lewismorgan.web.bootstrap.nav.navComponent
import com.lewismorgan.web.bootstrap.nav.navbar
import com.lewismorgan.web.bootstrap.nav.navbarBranding
import com.lewismorgan.web.bootstrap.nav.navbarCollapse
import com.lewismorgan.web.bootstrap.nav.navbarToggler
import com.lewismorgan.web.bootstrap.nav.navigationItem
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class WebsiteNavbarComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    // TODO: To show menu: In NavbarToggler remove "collapsed" class
    navbar("navbar-expand-lg navbar-dark fixed-top bg-dark", true) {
      div("container") {
        navbarBranding("#Home") {
          fontAwesome("map-marked-alt", FontAwesomeStyleType.SOLID)
        }
        navbarToggler {}
        navbarCollapse {
          navComponent {
            navigationItem("#Home", "Home")
            navigationItem("#Projects", "Projects")
            navigationItem("#Education", "Education")
            navigationItem("#Contact", "Contact")
          }
        }
      }
    }
  }
}