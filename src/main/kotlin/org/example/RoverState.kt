package org.example

data class RoverState(
    val positionX: Int = 0,
    val positionY: Int = 0,
    var heading: Heading = Heading.NORTH,
)
