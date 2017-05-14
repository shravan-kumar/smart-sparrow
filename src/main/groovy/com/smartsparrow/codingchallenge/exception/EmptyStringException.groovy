package com.smartsparrow.codingchallenge.exception

/**
 * EmptyStringException to warn regarding invalid entries
 */
class EmptyStringException extends Exception {

    EmptyStringException(String text) {
        super(text)
    }

    EmptyStringException() {
        super("Entered string is not valid!")
    }
}