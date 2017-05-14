package com.smartsparrow.codingchallenge.resolution

import com.smartsparrow.codingchallenge.domain.DateTime

/**
 * Time Confusion to resolve the correct time from the set of 3 three give values
 */
class TimeConfusion {

    /**
     * The function to find the correct time form three given values
     * @return A String explaining correct time or stating 'Look at the sun'
     * @throws NumberFormatException if the input is not recognised
     */
    public static void solveTimeConfusions() {
        BufferedReader stdin = System.in.newReader()
        List<String> solutions = new ArrayList<>()

        System.out.println("Please enter the number of cases you would like to resolve....")
        Integer numberOfHurdles
        try {
            numberOfHurdles = Integer.parseInt(stdin.readLine())
        } catch (Exception e) {
            throw new NumberFormatException("Invalid entry, only number are accepted for this entry")
        }

        for (int i = 0; i < numberOfHurdles; i++) {
            System.out.println("Please enter hours and minutes of " + (i + 1) + " case:")
            String entries = stdin.readLine()
            String[] entryList = entries.split(" ")
            DateTime correctTime
            try {
                correctTime = getCorrectTime(convertInputIntoDatTime(entryList))
                if (correctTime == null) {
                    solutions.add("look at the sun")
                } else {
                    solutions.add("The correct time is " + correctTime.convertTimeToProperFormat())
                }
            } catch (Exception e) {
                throw e
            }
        }
        solutions.each {
            println(it)
        }
    }

    /**
     * The function to get the correct time
     * @param List<DateTime> object containing correct date and time
     * @return An Object containing current position and grid and direction
     */
    private static DateTime getCorrectTime(List<DateTime> listOfDateTimeData) {
        DateTime correctTime = null
        int i = 0

        if (((DateTime.compareDateTime(listOfDateTimeData[i], listOfDateTimeData[i + 1])).equals(DateTime.compareDateTime(listOfDateTimeData[i + 2], listOfDateTimeData[i])))
        || ((DateTime.compareDateTime(listOfDateTimeData[i + 1], listOfDateTimeData[i])).equals(DateTime.compareDateTime(listOfDateTimeData[i], listOfDateTimeData[i + 2])))){
            correctTime = listOfDateTimeData[i]
        } else if (((DateTime.compareDateTime(listOfDateTimeData[i + 1], listOfDateTimeData[i + 2])).equals(DateTime.compareDateTime(listOfDateTimeData[i], listOfDateTimeData[i + 1])))
        || ((DateTime.compareDateTime(listOfDateTimeData[i + 2], listOfDateTimeData[i + 1])).equals(DateTime.compareDateTime(listOfDateTimeData[i + 1], listOfDateTimeData[i])))){
            correctTime = listOfDateTimeData[i + 1]
        } else if (((DateTime.compareDateTime(listOfDateTimeData[i + 2], listOfDateTimeData[i]).equals(DateTime.compareDateTime(listOfDateTimeData[i + 1], listOfDateTimeData[i + 2])))
        || ((DateTime.compareDateTime(listOfDateTimeData[i], listOfDateTimeData[i + 2])).equals(DateTime.compareDateTime(listOfDateTimeData[i + 2], listOfDateTimeData[i + 1]))))){
            correctTime = listOfDateTimeData[i + 2]
        }
        return correctTime
    }

    /**
     * The function to convert input into proper format of DateTime
     * @param List<String>. object containing input from the user
     * @return An List<DateTime> containing all the DateTime value created from user input
     */
    private static List<DateTime> convertInputIntoDatTime(String[] listOfTimeData) {
        if (listOfTimeData.length != 3) {
            throw new InputMismatchException("Input needs to have a total of 3 'time' entries")
        }

        List<DateTime> dateTimeList = new ArrayList<DateTime>()

        for (String time : listOfTimeData) {
            dateTimeList.add(getDateTime(time))
        }
        return dateTimeList
    }

    /**
     * The function to convert string into DateTime Object
     * @param String. object containing input from the user
     * @return An DateTime object containing value created from user input
     */
    private static DateTime getDateTime(String dateTimeInText) {
        String[] individualDateTime = dateTimeInText.split(":")
        DateTime dateTime = new DateTime(hour: DateTime.getHour(individualDateTime[0]),
                minute: DateTime.getMinute(individualDateTime[1]))
        return dateTime
    }
}
