# TODO

# RPP
- [ ] Refine Abstractions
  - [ ] long parameter list
  - [ ] data clump
  - [ ] primitive obsession
  - [ ] middle man
- [ ] Design Patterns
- [ ] SOLID++

# DONE
- [x] Make ktlint pass checks
- [x] Readability
  - [x] comments
  - [x] dead code
  - [x] magic strings/numbers
  - [x] bad naming
  - [x] antipattern
  - [x] scopes
- [x] Complexity
  - [x] long method
  - [x] duplicated code
- [x] Reorder Responsibilities
  - [x] long class
  - [x] feature envy
  - [x] inappropriate intimacy
  - [x] data class
  - [x] message chain

# Mikado
- [x] Clean up constants and private fields
  - [x] Move move() into Heading.move(Position)
  - [x] Move turnLeft() into Heading.turnLeft()
  - [x] Move turnRight() into Heading.turnRight()
    - [x] Remove HEADING_* constants
      - [x] in move() compare to heading enum
      - [x] in turnRight() compare to heading enum
      - [x] in turnLeft() compare to heading enum
        - [x] state.heading in Rover.constructor to enum
          - [x] Change heading Char in RoverState to Heading enum
            - [x] Create Heading enum
- [x] Change var to val (immutable)
  - [x] Rover.turnLeft use copy() on state
  - [x] Rover.turnRight use copy() on state
  - [x] Rover.move use copy() on state
  - [x] Rover.constructor use copy() on state
    - [x] Change RoverState to Data Class
