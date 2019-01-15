package io.lewismorgan.app.fragments


import kotlinx.html.classes
import kotlinx.html.title
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.img

interface GravatarProfileProps : RProps {
  var classes: String
  var alt: String
  var hash: String
  var size: Int
}

class GravatarProfileComponent : RComponent<GravatarProfileProps, RState>() {
  override fun RBuilder.render() {
    val requestString = if (props.size > 0) "${props.hash}?s=${props.size}" else props.hash
    img(props.alt, "https://www.gravatar.com/avatar/$requestString") {
      attrs.title = props.alt
      attrs.classes += "img-fluid"
      attrs.classes += props.classes
    }
  }
}

fun RBuilder.gravatar(hash: String, size: Int, alt: String, classes: String): ReactElement {
  return child<GravatarProfileProps, GravatarProfileComponent> {
    attrs.hash = hash
    attrs.size = size
    attrs.alt = alt
    attrs.classes = classes
  }
}