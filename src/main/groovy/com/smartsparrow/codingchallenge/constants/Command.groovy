package com.smartsparrow.codingchallenge.constants

/**
 * Enumeration representing valid commands
 */
enum Command {
    BB,
    CP,
    AN,
    SP,
    TC,
    HELP,
    EXIT,
    BYE

    /**
     * Matches command input to a Command enum value
     * @param input Input from user
     * @return Corresponding enum constant
     * @throws IllegalArgumentException if the input is not recognised (does not match to an enum value)
     */
    static Command correspondsTo(String input) {
        String parts = input.trim()

        try {
            return valueOf(parts.toUpperCase())
        } catch (IllegalArgumentException ignored) {
            throw new IllegalArgumentException("Command not found. Please issue one of ${values()}")
        }
    }
}