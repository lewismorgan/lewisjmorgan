package io.lewismorgan.app

import io.lewismorgan.app.bootstrap.dsl.card
import io.lewismorgan.app.bootstrap.dsl.cardBody
import io.lewismorgan.app.bootstrap.dsl.cardHeader
import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.fragments.FontAwesomeStyleType
import io.lewismorgan.app.fragments.fontAwesome
import io.lewismorgan.app.fragments.iconFont
import kotlinx.html.DIV
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.li
import react.dom.p
import react.dom.section
import react.dom.ul

class AboutComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    container("mb-5 mt-5") {
      section {
        div {
          renderAboutCard("", "Interests", { renderInterests() }, extra = null)
          renderAboutCard("mt-2", "Education", { renderEducation() }, extra = null)
        }
      }
    }
  }
}

private fun RBuilder.renderInterests() {
  div("card-text") {
    p {
      +" Among studying technology, my main points of interests are in programming for multi-platform systems, abstraction of systems, "
      +"all things Star Wars, religiously following developments in the new frontier, and avidly following Lord Elon Musk. "
    }
  }
}

private fun RBuilder.renderEducation() {
  div("card-text") {
    p {
      +"I'm a student currently attending the University of South Florida, pursing a degree in "
      +"Business Analytics & Information Systems, also known as Management of Information Systems. "
      +"From my studies and projects I've been able to perform comfortably with the following programming languages:"
    }
    ul("list-group about-list-group") {
      val listItemClasses = "list-group-item d-flex justify-content-between align-items-center"
      li(listItemClasses) {
        +"Java"
        iconFont("coffee")
      }
      li(listItemClasses) {
        +"Kotlin"
      }
      li(listItemClasses) {
        +"Swift"
        iconFont("apple")
      }
      li(listItemClasses) {
        +"Python"
      }
      li(listItemClasses) {
        +"VBA"
        iconFont("windows")
      }
    }
  }
}

private fun RDOMBuilder<DIV>.renderAboutCard(classes: String, header: String, body: RDOMBuilder<DIV>.() -> Unit,
                                             extra: (RDOMBuilder<DIV>.() -> Unit)? = null) {
  card {
    attrs.classes += classes
    cardHeader("card-header-about") {
      +header
    }
    cardBody {
      body()
    }
    extra?.invoke(this)
  }
}