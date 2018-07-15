package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.dsl.card
import com.lewismorgan.web.bootstrap.dsl.cardBody
import com.lewismorgan.web.bootstrap.dsl.cardHeader
import com.lewismorgan.web.bootstrap.dsl.container
import com.lewismorgan.web.fragments.FontAwesomeStyleType
import com.lewismorgan.web.fragments.fontAwesome
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
      +"all things Star Wars, religiously following developments in the new frontier, and avidly stalking Lord Elon Musk without regrets. "
    }
  }
}

private fun RBuilder.renderEducation() {
  div("card-text") {
    p {
      +"I'm a student currently attending the University of South Florida, pursing a degree in "
      +"Business Analytics & Information Systems, also known as Management of Information Systems. "
      +"From my studies and interests I've been able to perform comfortably with the following programming languages:"
    }
    ul("list-group about-list-group") {
      val listItemClasses = "list-group-item d-flex justify-content-between align-items-center"
      li(listItemClasses) {
        +"Java"
        fontAwesome("java", FontAwesomeStyleType.BRAND)
      }
      li(listItemClasses) {
        +"Kotlin"
      }
      li(listItemClasses) {
        +"Python"
        fontAwesome("python", FontAwesomeStyleType.BRAND)
      }
      li(listItemClasses) {
        +"VBA"
        fontAwesome("windows", FontAwesomeStyleType.BRAND)
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