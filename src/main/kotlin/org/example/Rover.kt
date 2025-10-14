package org.example

class Rover {
    constructor(commands: String) {
        val command = commands.split(' ')
        if (command.size >= ROVER_MINIMUM_NEEDED_COMMANDS) {
            state.positionX = command[ROVER_STARTING_POSITION_X].toInt()
            state.positionY = command[ROVER_STARTING_POSITION_Y].toInt()
            state.heading = Heading.from(command[ROVER_FACING_DIRECTION][ROVER_COMMANDLIST_DIRECTION]) ?: Heading.NORTH
        }
    }

    fun go(instructions: String) {
        for (instruction in instructions) {
            when (instruction) {
                COMMAND_TURN_LEFT -> turnLeft()
                COMMAND_TURN_RIGHT -> turnRight()
                COMMAND_MOVE -> move()
            }
        }
    }

    private fun move() {
        when (state.heading) {
            Heading.EAST -> state.positionX++
            Heading.SOUTH -> state.positionY--
            Heading.WEST -> state.positionX--
            Heading.NORTH -> state.positionY++
        }
    }

    private fun turnRight() {
        state.heading = state.heading.turnRight()
    }

    private fun turnLeft() {
        when (state.heading) {
            Heading.EAST -> state.heading = Heading.NORTH
            Heading.NORTH -> state.heading = Heading.WEST
            Heading.WEST -> state.heading = Heading.SOUTH
            Heading.SOUTH -> state.heading = Heading.EAST
        }
    }

    val position: String
        get() = "${state.positionX} ${state.positionY} ${state.heading}"

    fun pos(): String = position

    private var state = RoverState()
}

private const val ROVER_MINIMUM_NEEDED_COMMANDS = 3
private const val ROVER_STARTING_POSITION_X = 0
private const val ROVER_STARTING_POSITION_Y = 1
private const val ROVER_FACING_DIRECTION = 2
private const val ROVER_COMMANDLIST_DIRECTION = 0

private const val COMMAND_TURN_LEFT = 'L'
private const val COMMAND_TURN_RIGHT = 'R'
private const val COMMAND_MOVE = 'M'
