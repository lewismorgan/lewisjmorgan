package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.card
import com.lewismorgan.web.bootstrap.cardBody
import com.lewismorgan.web.bootstrap.cardFooter
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
import react.dom.section
import react.dom.span

/**
 * Created by lewis on 6/26/18.
 */
class ProjectsComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    section("mb-5 mt-5") {
      attrs["id"] = "projects"
      div("container") {
        div("row justify-content-md-center") {
          // TODO Move projects into data store
          renderProjectItem("lewisjmorgan", "Source code for my portfolio site", "lewisjmorgan")
          renderProjectItem("Harvester Droid", "Manage your resources across a number of Star Wars Galaxies resource trackers", "HarvesterDroid")
          renderProjectItem("Malzahar", "A reactive Kotlin library for Riot Games' League of Legends API", "Malzahar")
        }
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