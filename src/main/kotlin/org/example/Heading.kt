package org.example

enum class Heading(val symbol: Char, val deltaX: Int, val deltaY: Int) {
    NORTH('N', 0, 1),
    EAST('E', 1, 0),
    SOUTH('S', 0, -1),
    WEST('W', -1, 0),
    ;

    fun turnLeft(): Heading =
        when (this) {
            EAST -> NORTH
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
        }

    fun turnRight(): Heading =
        when (this) {
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
            NORTH -> EAST
        }

    fun move(
        x: Int,
        y: Int,
    ): Pair<Int, Int> = Pair(x + deltaX, y + deltaY)

    override fun toString(): String = symbol.toString()

    companion object {
        fun from(symbol: Char): Heading? = entries.firstOrNull { it.symbol == symbol }
    }
}
