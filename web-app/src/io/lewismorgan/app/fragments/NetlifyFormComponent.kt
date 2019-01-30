package io.lewismorgan.app.fragments

import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.form
import react.dom.input

interface NetlifyFormProps: RProps {
  var formName: String
}

interface NetlifyFormState: RState

class NetlifyFormComponent(props: NetlifyFormProps): RComponent<NetlifyFormProps, NetlifyFormState>(props) {
  override fun RBuilder.render() {
    form {
      attrs["name"] = props.formName
      attrs["data-netlify"] = "true"
      attrs["method"] = "POST"
      input(InputType.hidden, name = "form-name") {
        attrs["value"] = props.formName
      }
      children()
    }
  }
}