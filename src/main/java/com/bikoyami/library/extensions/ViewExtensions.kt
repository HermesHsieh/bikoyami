package com.bikoyami.library.extensions

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Retrieve property with default value from intent
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> FragmentActivity.getValue(key: String, default: T) = lazy {
    intent?.extras?.get(key) as? T ?: default
}

/**
 * Retrieve property with default value from intent
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> Fragment.getValue(key: String, default: T) = lazy {
    arguments?.get(key) as? T ?: default
}

inline fun <T : Fragment> T.withValues(argsBuilder: Bundle.() -> Unit): T = apply { arguments = Bundle().apply(argsBuilder) }


fun Activity.getScreenWidth(): Int {
    return with(DisplayMetrics()) {
        windowManager?.defaultDisplay?.getMetrics(this)
        widthPixels
    }
}

fun Activity.getScreenHeight(): Int {
    return with(DisplayMetrics()) {
        windowManager?.defaultDisplay?.getMetrics(this)
        heightPixels
    }
}

fun Fragment.getScreenWidth(): Int = activity?.getScreenWidth() ?: 0

fun Fragment.getScreenHeight(): Int = activity?.getScreenHeight() ?: 0


fun Activity.getStatusBarHeight(): Int {
    return resources.getIdentifier("status_bar_height", "dimen", "android").run {
        if (this > 0) {
            resources.getDimensionPixelSize(this)
        } else {
            0
        }
    }
}

fun Activity.getNavigationBarHeight(): Int {
    return resources.getIdentifier("navigation_bar_height", "dimen", "android").run {
        if (this > 0) {
            resources.getDimensionPixelSize(this)
        } else {
            0
        }
    }
}

fun Activity.isPortrait(): Boolean = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

fun Fragment.getStatusBarHeight(): Int = activity?.getStatusBarHeight() ?: 0

fun Fragment.getNavigationBarHeight(): Int = activity?.getNavigationBarHeight() ?: 0

fun Fragment.isPortrait(): Boolean = activity?.isPortrait() ?: false


fun View.setMarginTop(margin: Int): View {
    (this.layoutParams as ViewGroup.MarginLayoutParams).apply {
        setMargins(leftMargin, margin, rightMargin, bottomMargin)
    }.apply {
        this@setMarginTop.layoutParams = this
    }
    return this
}

fun View.setMarginRight(margin: Int): View {
    (this.layoutParams as ViewGroup.MarginLayoutParams).apply {
        setMargins(leftMargin, topMargin, margin, bottomMargin)
    }.apply {
        this@setMarginRight.layoutParams = this
    }
    return this
}

fun View.setMarginLeft(margin: Int): View {
    (this.layoutParams as ViewGroup.MarginLayoutParams).apply {
        setMargins(margin, topMargin, rightMargin, bottomMargin)
    }.apply {
        this@setMarginLeft.layoutParams = this
    }
    return this
}

fun View.setMarginBottom(margin: Int): View {
    (this.layoutParams as ViewGroup.MarginLayoutParams).apply {
        setMargins(leftMargin, topMargin, rightMargin, margin)
    }.apply {
        this@setMarginBottom.layoutParams = this
    }
    return this
}