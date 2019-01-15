package com.lewismorgan.web


import com.lewismorgan.web.bootstrap.dsl.container
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement

class ContactComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    container {
      attrs.classes += "twitter-feed"
    }
  }
}
