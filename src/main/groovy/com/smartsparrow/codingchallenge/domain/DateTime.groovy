package com.smartsparrow.codingchallenge.domain

/**
 * Table to define {@link DateTime} date and time for Time Confusion
 */
class DateTime {

    Integer hour
    Integer minute

    /**
     * Checks if two DateTime objects are equal {@link DateTime}
     * @param DateTime object
     * @return {@link Boolean} to indicate if check is true
     */
    public boolean equals(DateTime dateTime) {
        if (this.hour == dateTime.getHour() && this.minute == dateTime.getMinute()) {
            return true
        }
        return false
    }

    /**
     * Calculate two values (hours) and return the difference
     * @param Integer hour1
     * @param Integer hour2
     * @return {@link Integer} difference between two times
     */
    static private Integer compareHours(Integer hour1, Integer hour2) {
        Integer actualHour
        if (hour1 > hour2) {
            actualHour = 12 - hour1 + hour2
        } else {
            actualHour = hour2 - hour1
        }
        return actualHour
    }

    /**
     * Calculate two DateTime objects and create a new object {@link DateTime}
     * @param DateTime object1
     * @param DateTime object2
     * @return {@link Boolean} to indicate if check is true
     */
    static DateTime compareDateTime(DateTime dateTime1, DateTime dateTime2) {
        Integer hour = compareHours(dateTime1.hour, dateTime2.hour)
        Integer minute = compareMinutes(dateTime1.minute, dateTime2.minute)
        DateTime dateTime = new DateTime(hour: hour, minute: minute)
        return dateTime
    }

    /**
     * Calculate two values (minute) and return the difference
     * @param Integer minute1
     * @param Integer minute2
     * @return {@link Integer} difference between two times
     */
    static private Integer compareMinutes(Integer minute1, Integer minute2) {
        Integer actualMinute
        if (minute1 > minute2) {
            actualMinute = 60 - (minute1 + minute2)
        } else {
            actualMinute = minute2 - minute1
        }
        return actualMinute
    }

    /**
     * Convert minutes from String to Integer
     * @param String minute
     * @return {@link Integer}
     */
    static Integer getMinute(String minuteToBeCalculated) {
        return minuteToBeCalculated.toInteger()
    }

    /**
     * Convert hours from String to Integer
     * @param String hour
     * @return {@link Integer}
     */
    static Integer getHour(String hourToBeCalculated) {
        return hourToBeCalculated.toInteger()
    }

    /**
     * Convert DateTime object to readable to String
     * @param DateTime dateTime
     * @return {@link String}
     */
    public String convertTimeToProperFormat () {
        String convertedTime
        if (this.minute < 10) {
            convertedTime = this.hour + ":0" + this.minute
        } else {
            convertedTime = this.hour + ":" + this.minute
        }
        return convertedTime
    }
}
