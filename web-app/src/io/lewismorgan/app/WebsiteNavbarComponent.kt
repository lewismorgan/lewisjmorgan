package io.lewismorgan.app

import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.bootstrap.nav.navComponent
import io.lewismorgan.app.bootstrap.nav.navbar
import io.lewismorgan.app.bootstrap.nav.navbarBrand
import io.lewismorgan.app.bootstrap.nav.navbarCollapse
import io.lewismorgan.app.bootstrap.nav.navbarToggler
import io.lewismorgan.app.fragments.floatingItem
import io.lewismorgan.app.misc.getSmoothScrollingHandler
import io.lewismorgan.app.wrappers.navHashLink
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.i
import react.setState
import kotlin.browser.window

interface WebsiteNavbarProps : RProps {
  var collapsedMenuShown: Boolean
}

interface WebsiteNavbarState : RState {
  var collapsed: Boolean
  var scrollMinimized: Boolean
}

class WebsiteNavbarComponent(props: WebsiteNavbarProps) : RComponent<WebsiteNavbarProps, WebsiteNavbarState>(props) {
  override fun WebsiteNavbarState.init() {
    collapsed = true
    scrollMinimized = false
  }

  override fun WebsiteNavbarState.init(props: WebsiteNavbarProps) {
    collapsed = props.collapsedMenuShown
    scrollMinimized = false
  }

  override fun componentDidMount() {
    window.addEventListener("scroll", onScroll())
  }

  override fun componentWillUnmount() {
    window.removeEventListener("scroll", onScroll())
  }

  private fun onScroll(): (Event) -> Unit = {
    if (window.scrollY > 100) {
      setState {
        scrollMinimized = true
      }
    } else {
      setState {
        scrollMinimized = false
      }
    }
  }

  private fun onClickToggler(): (Event) -> Unit = {
    setState {
      collapsed = !collapsed
    }
  }

  private fun onSelectNavItem(@Suppress("UNUSED_PARAMETER") itemId: Int): (Event) -> Unit = {
    setState {
      collapsed = true
    }
  }

  override fun RBuilder.render() {
    navbar("navbar-expand-lg navbar-dark fixed-top bg-dark ${if (state.scrollMinimized) "navbar-shrink" else ""}") {
      container {
        navbarBrand("#") {
          +"LewisMorgan.io"
        }
        navbarToggler(state.collapsed, onClickToggler()) {}
        navbarCollapse(!state.collapsed) {
          navComponent({ i -> onSelectNavItem(i) }) {
            // TODO Move navigation items into a list so using children() will add non-nav items
            children()
          }
        }
      }
    }

    // TODO Move to own component and/or function depending on how advance I wanna make the falcon
    floatingItem {
      attrs.classes = "floating-lightspeeder"
      attrs.displayScrollOffset = 50
      navHashLink("#home", className = "btn btn-outline-light btn-floating-lightspeeder text-center", scroll = getSmoothScrollingHandler()) {
        i("swg swg-falcon-2 swg-4x") {}
      }
    }
  }
}
