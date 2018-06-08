package index

import com.lewismorgan.web.app.*
import com.lewismorgan.web.github.githubApp
import kotlinext.js.*
import react.dom.*
import kotlin.browser.*
import kotlin.js.RegExp

fun main(args: Array<String>) {
  requireAll(require.context("src", true, js("/\\.css$/") as RegExp))
  window.onload = {
    render(document.getElementById("root")!!) {
      app()
      githubApp()
    }
  }
}
