package com.monthly_expenses;

import com.util.calendar.MyCalendar;
import com.util.excel_reading.ExcelReading;

import java.text.DecimalFormat;

public class CalculateMonthlyExpenses {

    public static void main(String[] args) {
        String newspapers = "";
        double price = 0;
        String monthYear = "03/2020"; // MM/yyyy

        DecimalFormat df = new DecimalFormat(".00");
        /**
         * Add newspaper names in the array
         */
        String[] newspaperNames = {"Hindu"}; //91.0
        //String[] newspaperNames = {"TOI"}; //116.0
        //String[] newspaperNames = {"ET"}; //102.0
        //String[] newspaperNames = {"bm"};//46.5
        //String[] newspaperNames = {"ht"}; //80.0
        //String[] newspaperNames = {"TOI", "Hindu"}; //207.0
        //String[] newspaperNames = {"TOI", "Hindu", "ET"};
        //String[] newspaperNames = {"TOI", "Hindu", "ET", "bm"};
        //String[] newspaperNames = {"TOI", "Hindu", "ET", "bm", "Ht"};

        /**
         * Getting the last date of the current month
         */
        MyCalendar calendar = new MyCalendar(monthYear);
        int lastDateOfTheMonth = calendar.getLastDateOfTheMonth();

        for (int i = 0; i < newspaperNames.length; i++) {
            for (int j = 1; j <= lastDateOfTheMonth; j++) {
                /**
                 * getting the price for the each day
                 */
                price = price + Double.parseDouble(ExcelReading.getNewspaperChargers(newspaperNames[i]).get(calendar.getDay(j)));
            }
            /**
             * Adding newspaper names for printing
             */
            newspapers = newspaperNames[i] + ", " + newspapers;
        }

        System.out.println("You are subscribing " + newspapers + " newspapers and monthly charges : " + df.format(price) + "/- for " + calendar.getMonthName() + " month");
    }
}
