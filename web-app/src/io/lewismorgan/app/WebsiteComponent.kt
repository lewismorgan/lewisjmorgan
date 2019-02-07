package io.lewismorgan.app

import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.bootstrap.nav.navigationItem
import io.lewismorgan.app.fragments.iconFont
import io.lewismorgan.app.misc.getSmoothScrollingHandler
import io.lewismorgan.app.wrappers.navHashLink
import kotlinx.html.id
import react.Component
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.section
import react.dom.small
import react.dom.span
import kotlin.reflect.KClass

class WebsiteComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    child(WebsiteNavbarComponent::class) {
      attrs.collapsedMenuShown = true
      renderNavSectionItem("#home", "Home")
      renderNavSectionItem("#quotes", "Quotes")
      renderNavSectionItem("#about", "About")
      renderNavSectionItem("#projects", "Projects")
      renderNavSectionItem("#contact", "Contact")
    }
    renderSection("home", HeaderComponent::class) {}
    renderSection("quotes", WelcomeComponent::class) {}
    // the main contents for website
    div("mb-5 mt-5") {}
    renderSection("about", AboutComponent::class) {}
    renderSection("props", ProjectsComponent::class) {}
    renderSection("contact", ContactComponent::class) {}
    renderSection("footer", FooterComponent::class) {}
    renderCopyright()
  }

  private fun RBuilder.renderNavSectionItem(href: String, name: String) {
    navigationItem {
      // TODO: NavHashLinks broken for active status see https://github.com/rafrex/react-router-hash-link/issues/29
      navHashLink("/$href", className = "nav-link", activeClassName = "active", scroll = getSmoothScrollingHandler()) {
        +name
      }
    }
  }

  private fun <C : Component<RProps, *>> RBuilder.renderSection(id: String, klazz: KClass<C>, handler: RHandler<RProps>) {
    div {
      attrs.id = id
      child(klazz, handler)
    }
  }

  private fun RBuilder.renderCopyright() {
    section {
      attrs.id = "copyright"
      div("copyright text-center py-4 bg-dark text-white") {
        container {
          small("footer-notes") {
            span {
              +"Copyright "
            }
            iconFont("copyright")
            span {
              +" Lewis Morgan 2018. Source code is available on "
            }
            a("https://github.com/lewismorgan/lewisjmorgan") {
              +"GitHub"
            }
            span { +" " }
            iconFont("github-circled")
          }
        }
      }
    }
  }
}
