package org.example

class Rover {
    constructor(commands: String) {
        val command = commands.split(' ')
        if (command.size >= ROVER_MINIMUM_NEEDED_COMMANDS) {
            state.positionX = command[ROVER_STARTING_POSITION_X].toInt()
            state.positionY = command[ROVER_STARTING_POSITION_Y].toInt()
            state.direction = command[ROVER_FACING_DIRECTION][ROVER_COMMANDLIST_DIRECTION]
        }
    }

    fun go(instructions: String) {
        for (instruction in instructions) {
            when (instruction) {
                COMMAND_TURN_LEFT -> {
                    when (state.direction) {
                        DIRECTION_EAST -> state.direction = DIRECTION_NORTH
                        DIRECTION_NORTH -> state.direction = DIRECTION_WEST
                        DIRECTION_WEST -> state.direction = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> state.direction = DIRECTION_EAST
                    }
                }
                COMMAND_TURN_RIGHT -> {
                    when (state.direction) {
                        DIRECTION_EAST -> state.direction = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> state.direction = DIRECTION_WEST
                        DIRECTION_WEST -> state.direction = DIRECTION_NORTH
                        DIRECTION_NORTH -> state.direction = DIRECTION_EAST
                    }
                }
                COMMAND_MOVE -> {
                    when (state.direction) {
                        DIRECTION_EAST -> state.positionX++
                        DIRECTION_SOUTH -> state.positionY--
                        DIRECTION_WEST -> state.positionX--
                        DIRECTION_NORTH -> state.positionY++
                    }
                }
            }
        }
    }

    val position: String
        get() = "${state.positionX} ${state.positionY} ${state.direction}"

    fun pos(): String {
        return position
    }

    private var state = RoverState()
}

class RoverState {
    var positionX: Int = 0
    var positionY: Int = 0
    var direction: Char = DIRECTION_NORTH
}

private const val ROVER_MINIMUM_NEEDED_COMMANDS = 3
private const val ROVER_STARTING_POSITION_X = 0
private const val ROVER_STARTING_POSITION_Y = 1
private const val ROVER_FACING_DIRECTION = 2
private const val ROVER_COMMANDLIST_DIRECTION = 0

private const val COMMAND_TURN_LEFT = 'L'
private const val COMMAND_TURN_RIGHT = 'R'
private const val COMMAND_MOVE = 'M'

private const val DIRECTION_EAST = 'E'
private const val DIRECTION_NORTH = 'N'
private const val DIRECTION_WEST = 'W'
private const val DIRECTION_SOUTH = 'S'
