package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.nav.navigationItem
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.section
import react.dom.small
import react.dom.span

class WebsiteComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    child(WebsiteNavbarComponent::class) {
      attrs.collapsedMenuShown = true
      navigationItem("#home", "Home")
      navigationItem("#projects", "Projects")
      navigationItem("#education", "Education")
      navigationItem("#contact", "Contact")
    }
    section {
      attrs.id = "home"
      child(HeaderComponent::class) {}
      child(WelcomeComponent::class) {}
    }
    // the main contents for website
    section("mb-5 mt-5") {
      attrs.id = "projects"
      child(ProjectsComponent::class) {}
    }
    section {
      attrs.id = "education"
      child(EducationComponent::class) {}
    }
    section {
      attrs.id = "contact"
      child(ContactComponent::class) {}
    }
    child(FooterComponent::class) {}
    renderCopyright()
  }

  private fun RBuilder.renderCopyright() {
    section {
      attrs.id = "copyright"
      div("copyright text-center py-4 bg-dark text-white") {
        div("container") {
          small("footer-notes") {
            span {
              +"Copyright "
            }
            fontAwesome("copyright", FontAwesomeStyleType.REGULAR, FontAwesomeSize.XS)
            span {
              +" Lewis Morgan 2018. Source code is available on "
            }
            a("https://github.com/lewismorgan/lewisjmorgan") {
              +"GitHub"
            }
            span { +" " }
            fontAwesome("github", FontAwesomeStyleType.BRAND, FontAwesomeSize.DEFAULT, "fa-fw") {}
          }
        }
      }
    }
  }
}
