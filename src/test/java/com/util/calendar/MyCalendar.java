package com.util.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyCalendar {
    public static String getDay(int date) {
        String day = null;
        try {
            Calendar cal = Calendar.getInstance();
            String currentMonthAndYear = new SimpleDateFormat("MMMM/yyyy").format(cal.getTime());
            String oldDate = date + "/" + currentMonthAndYear;
            day = new SimpleDateFormat("EEEE").format(new SimpleDateFormat("dd/MMMM/yyyy").parse(oldDate)) + " Date : " + date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }
    public static int getLastDateOfTheMonth(){
        Calendar cal = Calendar.getInstance();
        return cal.getActualMaximum(Calendar.DATE);
    }
}
