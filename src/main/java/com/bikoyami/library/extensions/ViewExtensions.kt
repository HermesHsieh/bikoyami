package com.bikoyami.library.extensions

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