package com.lewismorgan.web

import react.*
import react.dom.*

class IndexAppComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    div("App-header") {
      h2 {
        +"Welcome to my website"
      }
    }
  }
}

fun RBuilder.indexAppComponent() = child(IndexAppComponent::class) {}
