package org.example

enum class Heading(val symbol: Char) {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W'),
    ;

    fun turnLeft() = when (this) {
        EAST -> NORTH
        NORTH -> WEST
        WEST -> SOUTH
        SOUTH -> EAST
    }

    fun turnRight() = when (this) {
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
