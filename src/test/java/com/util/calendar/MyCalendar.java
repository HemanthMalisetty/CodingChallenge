package com.util.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyCalendar {
    String monthYear = "";
    /**
     * Getting the day for date
     */
    public MyCalendar(String monthYear){
        this.monthYear = monthYear;
    }
    public String getDay(int date) {
        String day = null;
        try {
            String oldDate = date + "/" + monthYear;
            day = new SimpleDateFormat("EEEE").format(new SimpleDateFormat("dd/MM/yyyy").parse(oldDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * Getting the last date of the month
     */
    public int getLastDateOfTheMonth() {
        String[] monthNameYear = monthYear.split("/");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.valueOf(monthNameYear[1]), Integer.valueOf(monthNameYear[0])-1, 1);
        return cal.getActualMaximum(cal.DAY_OF_MONTH);
    }

    public String getMonthName() {
        String month = null;
        try {
            month = new SimpleDateFormat("MMMM-yyyy").format(new SimpleDateFormat("MM/yyyy").parse(monthYear));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return month;
    }
}
