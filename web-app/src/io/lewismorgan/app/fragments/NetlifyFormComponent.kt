package io.lewismorgan.app.fragments

import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.form
import react.dom.input
import react.dom.textArea

interface NetlifyFormProps: RProps {
  var method: String
  var formName: String
  var inputElements: List<InputElement>
}

data class InputElement(val type: UserEntryType, val name: String)

interface NetlifyFormState: RState

/**
 * A Component that works with Netlify's form's features. Implementation details taken for the blog post at
 * https://www.netlify.com/blog/2017/07/20/how-to-integrate-netlifys-form-handling-in-a-react-app/#form-handling-with-a-stateless-react-form
 * @constructor
 */
class NetlifyFormComponent(props: NetlifyFormProps): RComponent<NetlifyFormProps, NetlifyFormState>(props) {
  override fun RBuilder.render() {
    // This is the hidden form that Netlify requires to function properly
    form {
      attrs["name"] = props.formName
      attrs["data-netlify"] = "true"
      attrs["data-netlify-honeypot"] = "bot-field"
      attrs["hidden"] = Any()

      // Create the hidden elements for Netlify based off of the InputElement's that are in the props
      props.inputElements.forEach {
        when(it.type) {
          UserEntryType.EMAIL -> input(InputType.email, name = it.name) {}
          UserEntryType.TEXT -> input(InputType.text, name = it.name) {}
          UserEntryType.TEXT_AREA -> textArea {
            attrs["name"] = it.name
          }
        }
      }
    }
    form {
      attrs["name"] = props.formName
      attrs["method"] = props.method
      input(InputType.hidden, name = "form-name") {
        attrs["value"] = props.formName
      }
      children()
    }
  }
}

enum class UserEntryType {
  EMAIL,
  TEXT,
  TEXT_AREA
}