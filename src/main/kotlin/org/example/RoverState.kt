package org.example

data class RoverState(
    val position: Position = Position(),
    var heading: Heading = Heading.NORTH,
) {
    fun turnLeft(): RoverState = copy(heading = heading.turnLeft())

    fun turnRight(): RoverState = copy(heading = heading.turnRight())

    fun move(): RoverState {
        val (newX, newY) = heading.move(position.x, position.y)
        return copy(position = Position(newX, newY))
    }
}
