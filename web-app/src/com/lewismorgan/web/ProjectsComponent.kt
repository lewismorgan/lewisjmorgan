package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.dsl.card
import com.lewismorgan.web.bootstrap.dsl.cardBody
import com.lewismorgan.web.bootstrap.dsl.cardFooter
import com.lewismorgan.web.bootstrap.dsl.container
import kotlinx.html.DIV
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div
import react.dom.h5
import react.dom.p
import react.dom.span

/**
 * Created by lewis on 6/26/18.
 */
class ProjectsComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    container {
      div("row justify-content-md-center") {
        renderProjectItem("lewisjmorgan", "Source code for my portfolio site", "lewisjmorgan")
        renderProjectItem("Holodex", "An iOS app that tells you information from SWAPI.co", "Holodex")
        renderProjectItem("Harvester Droid", "Manage your resources across a number of Star Wars Galaxies resource trackers", "HarvesterDroid")
      }
    }
  }

  private fun RDOMBuilder<DIV>.renderProjectItem(name: String, text: String, projectId: String) {
    div("col-12 col-md-4") {
      card {
        attrs.classes += "mb-2"
        cardBody {
          h5("card-title") {
            +name
          }
          p("card-text") {
            +text
          }
          a("https://www.github.com/lewismorgan/$projectId", classes = "btn btn-primary") { +"View on GitHub" }
        }
        cardFooter {
          span("text-muted") { +"Last commit was 2 days ago" }
        }
      }
    }

  }
}