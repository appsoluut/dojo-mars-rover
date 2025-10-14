package org.example

enum class Heading(val symbol: Char, val vector: Vector) {
    NORTH('N', Vector(0, 1)),
    EAST('E', Vector(1, 0)),
    SOUTH('S', Vector(0, -1)),
    WEST('W', Vector(-1, 0)),
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

    override fun toString(): String = symbol.toString()

    companion object {
        fun from(symbol: Char): Heading? = entries.firstOrNull { it.symbol == symbol }
    }
}
