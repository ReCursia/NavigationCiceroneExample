package com.recursia.navigationciceroneexample

fun getChainText(counter: Int) = buildString {
    for (count in 1..counter) {
        if (count == 1) {
            append(count)
        } else {
            append(" → $count")
        }
    }
}