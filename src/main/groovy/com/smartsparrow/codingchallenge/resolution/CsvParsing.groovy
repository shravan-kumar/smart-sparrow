package com.smartsparrow.codingchallenge.resolution

import com.smartsparrow.codingchallenge.exception.EmptyStringException

/**
 * CSV parsing program to print all the element of a string separated by ','
 */
class CsvParsing {

    /**
     * The function to convert string into array after separating the string by ','
     * @return An array of strings
     * @throws EmptyStringException if the input is not recognised
     */
    public static void parseCsvString() {

        System.out.println("Please enter the string you would " +
                "like to parse")
        BufferedReader stdin = System.in.newReader()
        String expression = stdin.readLine()
        String cvsSplitBy = ',(?=([^"]*"[^"]*")*[^"]*$)'


        if (expression == "" || expression == null) {
            throw new EmptyStringException("Entered string is not valid!")
        }

        String[] result = expression.split(cvsSplitBy)
        for (String element : result)
        {
            System.out.println(element)
        }
    }
}
