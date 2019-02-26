package io.lewismorgan.app


import io.lewismorgan.app.bootstrap.dsl.card
import io.lewismorgan.app.bootstrap.dsl.cardBody
import io.lewismorgan.app.bootstrap.dsl.container
import io.lewismorgan.app.fragments.InputElement
import io.lewismorgan.app.fragments.NetlifyFormComponent
import io.lewismorgan.app.fragments.UserEntryType
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.h3
import react.dom.h6
import react.dom.input
import react.dom.label
import react.dom.textArea

class ContactComponent : RComponent<RProps, RState>() {

  private fun RBuilder.simpleInputFormItem(htmlFor: String, labelStr: String, inputType: InputType, placeholder: String) {
    div("form-group") {
      label {
        attrs["htmlFor"] = htmlFor
        +labelStr
      }
      input(inputType, null, null, htmlFor, "form-control") {
        attrs["placeholder"] = placeholder
      }
    }
  }
  
  override fun RBuilder.render() {
    container("contact") {
      card {
        h3("card-header") { +"Contact" }
        cardBody {
          h6("card-subtitle text-muted") {
            + "I'll reach out to you faster than Jar Jar gets his tongue caught by Qui-Gon... Long as you fill this out."
          }
          child(NetlifyFormComponent::class) {
            attrs.formName = "contact"
            // InputElements should remain in order
            attrs.inputElements = listOf(
              InputElement(UserEntryType.TEXT, "name"),
              InputElement(UserEntryType.TEXT, "email"),
              InputElement(UserEntryType.TEXT_AREA, "message")
            )
            attrs.method = FormMethod.post
            simpleInputFormItem("name", "Name/Company", InputType.text, "Your name or Company")
            simpleInputFormItem("email", "Email", InputType.email, "Email I can respond to")
            div("form-group") {
              label {
                attrs["htmlFor"] = "message"
                +"Message"
              }
              textArea("3", classes = "form-control"){
                attrs.name = "message"
                attrs["placeholder"] = "Hey Lewis, check out this dope \"Hello There\" Obi-Wan meme..."
              }
            }
          }
        }
      }
    }
  }
}
