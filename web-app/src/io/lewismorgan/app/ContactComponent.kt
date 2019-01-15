package io.lewismorgan.app


import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.fragments.NetlifyFormComponent
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.form

class ContactComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    container("contact") {
      child(NetlifyFormComponent::class) {

      }
    }
  }
}
