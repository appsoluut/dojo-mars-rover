package org.example

enum class Heading(val symbol: Char) {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W'),
    ;

    override fun toString(): String = symbol.toString()

    companion object {
        fun from(symbol: Char): Heading? = entries.firstOrNull { it.symbol == symbol }
    }
}
