package org.example

class Rover {
    constructor(p: String) {
        val s = p.split(' ')
        if (s.size >= ROVER_MINIMUM_NEEDED_COMMANDS) {
            rs.xx = s[ROVER_STARTING_POSITION_X].toInt()
            rs.yy = s[ROVER_STARTING_POSITION_Y].toInt()
            rs.dd = s[ROVER_COMMANDLIST][ROVER_COMMANDLIST_FIRST_COMMAND]
        }
    }

    fun go(cms: String) {
        for (c in cms) {
            when (c) {
                COMMAND_TURN_LEFT -> {
                    when (rs.dd) {
                        DIRECTION_EAST -> rs.dd = DIRECTION_NORTH
                        DIRECTION_NORTH -> rs.dd = DIRECTION_WEST
                        DIRECTION_WEST -> rs.dd = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> rs.dd = DIRECTION_EAST
                    }
                }
                COMMAND_TURN_RIGHT -> {
                    when (rs.dd) {
                        DIRECTION_EAST -> rs.dd = DIRECTION_SOUTH
                        DIRECTION_SOUTH -> rs.dd = DIRECTION_WEST
                        DIRECTION_WEST -> rs.dd = DIRECTION_NORTH
                        DIRECTION_NORTH -> rs.dd = DIRECTION_EAST
                    }
                }
                COMMAND_MOVE -> {
                    when (rs.dd) {
                        DIRECTION_EAST -> rs.xx++
                        DIRECTION_SOUTH -> rs.yy--
                        DIRECTION_WEST -> rs.xx--
                        DIRECTION_NORTH -> rs.yy++
                    }
                }
            }
        }
    }

    val xyd: String
        get() = "${rs.xx} ${rs.yy} ${rs.dd}"

    fun pos(): String {
        return xyd
    }

    private var rs = RoverState()
}

class RoverState {
    var xx: Int = 0
    var yy: Int = 0
    var dd: Char = DIRECTION_NORTH
}

private const val ROVER_MINIMUM_NEEDED_COMMANDS = 3
private const val ROVER_STARTING_POSITION_X = 0
private const val ROVER_STARTING_POSITION_Y = 1
private const val ROVER_COMMANDLIST = 2
private const val ROVER_COMMANDLIST_FIRST_COMMAND = 0

private const val COMMAND_TURN_LEFT = 'L'
private const val COMMAND_TURN_RIGHT = 'R'
private const val COMMAND_MOVE = 'M'

private const val DIRECTION_EAST = 'E'
private const val DIRECTION_NORTH = 'N'
private const val DIRECTION_WEST = 'W'
private const val DIRECTION_SOUTH = 'S'
