package com.lewismorgan.web

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.small
import react.dom.span

class WebsiteComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    child(WebsiteNavbarComponent::class) {
      attrs.collapsedMenuShown = true
    }
    child(HeaderComponent::class) {}
    child(WelcomeComponent::class) {}
    // the main contents for website
    child(ProjectsComponent::class) {}
    child(EducationComponent::class) {}
    child(ContactComponent::class) {}
    child(FooterComponent::class) {}
    renderCopyright()
  }

  private fun RBuilder.renderCopyright() {
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
