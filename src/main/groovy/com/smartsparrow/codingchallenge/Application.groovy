package com.smartsparrow.codingchallenge

import com.smartsparrow.codingchallenge.resolution.AnagramLookup
import com.smartsparrow.codingchallenge.resolution.BalancedBracket
import com.smartsparrow.codingchallenge.constants.Command
import com.smartsparrow.codingchallenge.resolution.CsvParsing
import com.smartsparrow.codingchallenge.resolution.Spiral
import com.smartsparrow.codingchallenge.resolution.TimeConfusion

/**
 * Pseudo "Controller" that accepts input from a user via CLI (from {@link CommandLine}, or any other interface implementation of choice.<br/>
 * Responsible for communication with, and manipulation of domain objects.
 */
class Application {
    static final String HELP_MSG = "Application accepts the input commands " +
            "${Command.values()}.\n" +
            "\t${Command.BB} (For Balanced Bracket)\n" +
            "\t- This checks weather a given string is in balanced or not. \n" +
            "\t  That is, every opening bracket must have a closing bracket of the same type following it, \n" +
            "\t  and the string in between the pair must also be balanced.\n" +
            "\t${Command.CP} (For CSV Parsing)\n" +
            "\t- This program accepts a input string separated by comma, This extracts\n" +
            "\t  all the string from and display on the screen.\n" +
            "\t${Command.AN} (For Anagram Lookup)\n" +
            "\t- The anagram look up function look for a pattern and find all the\n" +
            "\t  possible value exist in a string provided by user, and hence display the result of teh screen.\n" +
            "\t${Command.SP} (For Spiral Way Out)\n" +
            "\t- This program accepts four input row, column, x position and y position to start search from\n" +
            "\t  After creating a grid from row and columns provided\n" +
            "\t  This starts from the given starting point to look for way out of spiral and print the\n" +
            "\t  on the screen\n" +
            "\t${Command.TC} (For Time Confusing)\n" +
            "\t- This is time cracking function which accepts multiple entries as user input\n" +
            "\t  Each entry will contain three time, from which this function will look for the correct one\n" +
            "\t  and displays on teh screen\n" +
            "\t${Command.HELP}\n" +
            "\t- Prints this message\n" +
            "\t${Command.EXIT} or ${Command.BYE}\n" +
            "\t- Closes this app"


    /**
     * Accepts a single command from input source, validates and executes the necessary domain object methods corresponding to the command
     *
     * @param input User entered command from undetermined input source
     * @return A string if output is to be displayed, or null
     *
     * @throws InterruptedException When the user has issued an EXIT command
     * @throws IllegalArgumentException When a command is invalid
     */
    String execute(String input) {
        Command command = Command.correspondsTo(input)

        switch (command) {
            case Command.EXIT:
            case Command.BYE:
                println("Good Bye!")
                throw new InterruptedException()

            case Command.HELP:
                return HELP_MSG

            case Command.BB:
                try {
                    if (BalancedBracket.checkBalancedBracket()) { System.out.println("Balanced\n");}
                    else { System.out.println("Not Balanced\n");}
                    return null
                } catch (Exception e) {
                    throw e
                }
                return null
            case Command.CP:
                try {
                    CsvParsing.parseCsvString()
                    return null
                } catch (Exception e) {
                    throw e
                }
                return null
            case Command.AN:
                try {
                    AnagramLookup.searchAnagramSubstring()
                    return null
                } catch (Exception e) {
                    throw e
                }
                return null
            case Command.SP:
                try {
                    Spiral.wayOutAntiClockwise()
                    return null
                } catch (Exception e) {
                    throw e
                }
                return null
            case Command.TC:
                try {
                    TimeConfusion.solveTimeConfusions()
                    return null
                } catch (Exception e) {
                    throw e
                }
                return null
        }
        return null
    }
}
