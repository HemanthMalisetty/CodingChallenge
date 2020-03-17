package com.monthly_expenses;


import com.util.calendar.MyCalendar;
import com.util.excel_reading.ExcelReading;

public class CalculateMonthlyExpenses {
    public static void main(String[] args) {
        int lastDateOfTheMonth = MyCalendar.getLastDateOfTheMonth();
        double price = 0;
        for (int i = 1; i <= lastDateOfTheMonth; i++){
            price = price + Double.parseDouble(ExcelReading.getNewspaperChargers("TOI").get(MyCalendar.getDay(i)));
            //System.out.println(ExcelReading.getNewspaperChargers("TOI").get(MyCalendar.getDay(i)));
        }
        System.out.println(price);
        //System.out.println(ExcelReading.getNewspaperChargers("TOI"));
    }
}
