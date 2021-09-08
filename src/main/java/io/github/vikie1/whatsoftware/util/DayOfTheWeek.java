package io.github.vikie1.whatsoftware.util;

import java.util.Calendar;

public class DayOfTheWeek {

    static public String getDayById(int dayNumber) {
        switch (dayNumber){
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                throw new DayNotFoundException("Expected 1 <= " + dayNumber + " <= 7 " );
        }
    }

    static public int getIdByDay(String dayOfTheWeek){
        switch (dayOfTheWeek.toLowerCase()){
            case "sunday":
                return Calendar.SUNDAY;
            case "monday":
                return Calendar.MONDAY;
            case "tuesday":
                return Calendar.TUESDAY;
            case "wednesday":
                return Calendar.WEDNESDAY;
            case "thursday":
                return Calendar.THURSDAY;
            case "friday":
                return Calendar.FRIDAY;
            case "saturday":
                return Calendar.SATURDAY;
            default: throw new DayNotFoundException("Expected English Days Monday - Sunday");
        }
    }

    static class DayNotFoundException extends Error{
        DayNotFoundException(String exceptionMessage){ super(exceptionMessage); }
    }
}
