package io.lewismorgan.app.fragments

import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import org.w3c.fetch.RequestInit
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.form
import react.dom.input
import react.dom.textArea
import react.setState
import kotlin.browser.window
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.forEach
import kotlin.collections.hashMapOf
import kotlin.collections.set
import kotlin.collections.toMap

interface NetlifyFormProps: RProps {
  var method: FormMethod
  var formName: String
  var inputElements: List<InputElement>
}

data class InputElement(val type: UserEntryType, val name: String)

interface NetlifyFormState: RState {
  var elementValues: Map<String, String>
}

/**
 * A Component that works with Netlify's form's features. Implementation details taken for the blog post at
 * https://www.netlify.com/blog/2017/07/20/how-to-integrate-netlifys-form-handling-in-a-react-app/#form-handling-with-a-stateless-react-form
 * @constructor
 */
class NetlifyFormComponent(props: NetlifyFormProps): RComponent<NetlifyFormProps, NetlifyFormState>(props) {

  override fun NetlifyFormState.init(props: NetlifyFormProps) {
    // Create element values for each inputElement
    val items = hashMapOf<String, String>()
    props.inputElements.forEach {
      items[it.name] = ""
    }

    elementValues = items.toMap()
  }

  private fun handleChange(event: Event) {
    val target = event.target as HTMLElement

    val name = target.attributes.getNamedItem("name")!!
    val tag = target.localName
    var value = ""

    when(tag) {
      "input" -> value = (event.target as HTMLInputElement).value
      "textarea" -> value = ((event.target) as HTMLTextAreaElement).value
    }

    val newValues = hashMapOf<String, String>()

    props.inputElements.forEach  {
      if (it.name == name.value) {
        // name of the value to change in the state's elementValues
        newValues[it.name] = value
      } else {
        newValues[it.name] = ""
      }
    }

    // Update the state to the new values with a copy of the map (because async)
    setState {
      elementValues = newValues.toMap()
    }
  }

  private fun submitFormData() {
    val headers: dynamic = object {}
    headers["Content-Type"] = "application/x-www-form-urlencoded"


    val encodable: dynamic = object {}
    encodable["form-name"] = props.formName
    state.elementValues.forEach { (k, v) ->
      encodable[k] = v
    }

    window.fetch("/", RequestInit("POST", headers = headers, body = encode(toEncode = encodable))).then { response -> {
      console.log(response)
    }}.catch { error ->  {
      window.alert(error.message.orEmpty())
    } }
  }

  override fun RBuilder.render() {
    // hidden form that Netlify requires to function properly (maybe it's not needed with POST submit ...?)
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
      attrs {
        name = props.formName
        method = props.method
        onChangeFunction = { handleChange(it) }
      }
      input(InputType.hidden, name = "form-name") {
        attrs["value"] = props.formName
      }
      children()
      button(type = ButtonType.submit, classes = "btn btn-primary") {
        +"Submit"
        attrs.onClickFunction = { _ -> submitFormData() }
      }
    }
  }
}

enum class UserEntryType {
  EMAIL,
  TEXT,
  TEXT_AREA
}

external fun encode(toEncode: dynamic): dynamic