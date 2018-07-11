package com.lewismorgan.web.misc

import org.w3c.dom.Document
import org.w3c.dom.Element

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