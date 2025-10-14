package org.example

data class Position(
    val x: Int = 0,
    val y: Int = 0,
) {
    fun moveBy(vector: Vector): Position = copy(x = x + vector.deltaX, y = y + vector.deltaY)

    override fun toString(): String = "$x $y"
}
