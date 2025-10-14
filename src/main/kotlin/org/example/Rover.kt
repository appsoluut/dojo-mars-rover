package org.example

class Rover {
    constructor(commands: String) {
        val command = commands.split(' ')
        if (command.size >= ROVER_MINIMUM_NEEDED_COMMANDS) {
            state.positionX = command[ROVER_STARTING_POSITION_X].toInt()
            state.positionY = command[ROVER_STARTING_POSITION_Y].toInt()
            state.heading = command[ROVER_FACING_DIRECTION][ROVER_COMMANDLIST_DIRECTION]
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
            HEADING_EAST -> state.positionX++
            HEADING_SOUTH -> state.positionY--
            HEADING_WEST -> state.positionX--
            HEADING_NORTH -> state.positionY++
        }
    }

    private fun turnRight() {
        when (state.heading) {
            HEADING_EAST -> state.heading = HEADING_SOUTH
            HEADING_SOUTH -> state.heading = HEADING_WEST
            HEADING_WEST -> state.heading = HEADING_NORTH
            HEADING_NORTH -> state.heading = HEADING_EAST
        }
    }

    private fun turnLeft() {
        when (state.heading) {
            HEADING_EAST -> state.heading = HEADING_NORTH
            HEADING_NORTH -> state.heading = HEADING_WEST
            HEADING_WEST -> state.heading = HEADING_SOUTH
            HEADING_SOUTH -> state.heading = HEADING_EAST
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

internal const val HEADING_EAST = 'E'
internal const val HEADING_NORTH = 'N'
internal const val HEADING_WEST = 'W'
internal const val HEADING_SOUTH = 'S'
