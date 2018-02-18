package com.lewismorgan.web.github

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.img
import react.dom.p


@JsModule("simple-icons/icons/githubApp.svg")
external val githubLogo: dynamic

/**
 * Created by lewis on 1/14/18.
 */
class GitHubApp : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    div("GitHub") {
      p { +"Check out these commits!" }
      a(href = "https://www.githubApp.com/Waverunner") {
        img(src = githubLogo, classes = "GitHub-Logo", alt = "GitHub Logo") {}
      }
    }
  }
}

fun RBuilder.githubApp() = child(GitHubApp::class) {}
