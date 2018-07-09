package com.lewismorgan.web.misc

import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children

/**
 * Return a list of all the children elements for the receiver. A single element in the children is
 * transformed to an array automatically for type safety.
 * @receiver RComponent<P, S>
 * @return Array<ReactElement>
 */
fun <P : RProps, S : RState> RComponent<P, S>.getChildren(): Array<ReactElement> {
  return if (jsIsArray(props.children)) {
    props.children.unsafeCast<Array<ReactElement>>()
  } else {
    // If there is a single element, it's not known as an array just an object
    arrayOf(props.children.unsafeCast<ReactElement>())
  }
}
