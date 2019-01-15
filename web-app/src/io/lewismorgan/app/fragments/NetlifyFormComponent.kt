package io.lewismorgan.app.fragments

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.form

interface NetlifyFormProps: RProps
interface NetlifyFormState: RState

class NetlifyFormComponent(props: NetlifyFormProps): RComponent<NetlifyFormProps, NetlifyFormState>(props) {
  override fun RBuilder.render() {
    form {
      attrs["netlify"] = ""
      children()
    }
  }
}