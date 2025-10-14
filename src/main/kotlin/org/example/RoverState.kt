package org.example

data class RoverState(
    val positionX: Int = 0,
    val positionY: Int = 0,
    var heading: Heading = Heading.NORTH,
) {
    fun turnLeft(): RoverState = copy(heading = heading.turnLeft())

    fun turnRight(): RoverState = copy(heading = heading.turnRight())

    fun move(): RoverState {
        val (newX, newY) = heading.move(positionX, positionY)
        return copy(positionX = newX, positionY = newY)
    }
}
