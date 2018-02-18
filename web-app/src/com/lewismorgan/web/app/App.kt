package com.lewismorgan.web.app

import react.*
import react.dom.*

class App : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    div("App-header") {
      h2 {
        +"Welcome to my website"
      }
    }
  }
}

fun RBuilder.app() = child(App::class) {}
