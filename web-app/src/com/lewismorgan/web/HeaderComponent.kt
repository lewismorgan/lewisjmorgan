package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.dsl.container
import com.lewismorgan.web.children.FontAwesomeStyleType
import com.lewismorgan.web.children.fontAwesome
import com.lewismorgan.web.children.gravatar
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.header
import react.dom.i
import react.dom.li
import react.dom.span
import react.dom.ul

/**
 * Created by lewis on 6/25/18.
 */
class HeaderComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    header("masthead bg-primary text-center") {
      container {
        gravatar("537a20df74eade54fb872702713d3e23", 225, "( ͡° ͜ʖ ͡°)", "mx-auto rounded-circle mb-3")
        container {
          h1 { +"Lewis Morgan" }
          ul("list-stack") {
            li("list-stack-item") {
              span { +"Student " }
              fontAwesome("user-graduate", FontAwesomeStyleType.SOLID)
            }
            li("list-stack-item") {
              span { +"Developer " }
              fontAwesome("code", FontAwesomeStyleType.SOLID)
            }
            li("list-stack-item") {
              span { +"Star Wars Fanatic " }
              i("swg swg-deathstar") {}
            }
          }
        }
      }
    }
  }
}