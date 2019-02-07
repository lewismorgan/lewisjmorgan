package io.lewismorgan.app.fragments

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.i

interface IconFontProps: RProps {
  var classes: String
  var icon: String
}

class IconFontComponent(props: IconFontProps): RComponent<IconFontProps, RState>(props) {
  override fun RBuilder.render() {
    i("icon-${props.icon}${if (props.classes.isNotEmpty()) " ${props.classes}" else ""}") {}
  }
}

fun RBuilder.iconFont(name: String, classes: String = ""): ReactElement {
  return child(IconFontComponent::class) {
    attrs.classes = classes
    attrs.icon = name
  }
}