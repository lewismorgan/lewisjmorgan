package com.lewismorgan.web.misc

import kotlinext.js.asJsObject
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.children
import kotlin.browser.window

/**
 * Created by lewis on 6/23/18.
 */
@Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER")
inline fun jsIsArray(a: Any?) = js("typeof a === 'object' && a.constructor === Array") as Boolean

/**
 * Converts the array of functions into a single function for handlers that take a single function.
 * @param functions Array<out Function1<Event, Unit>>
 * @return (Event) -> Unit
 */
fun <T> chainedFunction(vararg functions: (T) -> Unit): (T) -> Unit {
  return functions.reduce { acc, func ->
    {
      acc.apply { func(it) }
      func.apply { acc(it) }
    }
  }
}

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

fun RBuilder.navHashLink(to: String,
                         className: String? = null,
                         activeClassName: String = "active",
                         onClick: ((Event) -> Unit)? = null,
                         scroll: ((Element) -> Unit)? = null,
                         handler: RHandler<NavHashLinkProps>) = child<NavHashLinkProps, NavHashLinkComponent> {
  attrs {
    this.to = to
    this.className = className
    this.activeClassName = activeClassName
    this.smooth = true
    if (onClick != null)
      this.onClick = onClick
    if (scroll != null)
      this.scroll = scroll
  }
  handler.invoke(this)
}

fun getScrollTop(document: Document): Double {
  val element = if (document.scrollingElement != null) document.scrollingElement else document.documentElement
  return element!!.scrollTop
}

fun getSmoothScrollingHandler(): (Element) -> Unit = {
  //it.scrollIntoView(js("{ behavior: 'smooth' }"))
  // Some browsers like Safari don't support scrolling into view with options...
  // TODO: Create zenscroll Kotlin class
  @Suppress("UnsafeCastFromDynamic")
  js("zenscroll.intoView(it)")
}