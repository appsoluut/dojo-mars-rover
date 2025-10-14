package org.example

class Rover {
    constructor(commands: String) {
        val command = commands.split(' ')
        if (command.size >= ROVER_MINIMUM_NEEDED_COMMANDS) {
            val position =
                Position(
                    x = command[ROVER_STARTING_POSITION_X].toInt(),
                    y = command[ROVER_STARTING_POSITION_Y].toInt(),
                )
            state = state.copy(position = position)
            Heading.from(command[ROVER_FACING_DIRECTION][ROVER_COMMANDLIST_DIRECTION])?.let {
                state = state.copy(heading = it)
            }
        }
    }

    fun go(instructions: String) {
        for (instruction in instructions) {
            state =
                when (instruction) {
                    COMMAND_TURN_LEFT -> state.turnLeft()
                    COMMAND_TURN_RIGHT -> state.turnRight()
                    COMMAND_MOVE -> state.move()
                    else -> state
                }
        }
    }

    val position: String
        get() = "${state.position} ${state.heading}"

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
