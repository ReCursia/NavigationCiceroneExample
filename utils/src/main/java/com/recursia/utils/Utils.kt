package com.recursia.utils

fun getChainText(counter: Int) = buildString {
    for (count in 1..counter) {
        if (count == 1) {
            append(count)
        } else {
            append(" → $count")
        }
    }
}