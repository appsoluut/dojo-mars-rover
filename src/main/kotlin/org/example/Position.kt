package org.example

data class Position(
    val x: Int = 0,
    val y: Int = 0,
) {
    override fun toString(): String = "$x $y"
}
