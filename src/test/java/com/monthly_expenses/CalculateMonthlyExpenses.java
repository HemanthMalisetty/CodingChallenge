package com.monthly_expenses;

import com.util.calendar.MyCalendar;
import com.util.excel_reading.ExcelReading;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateMonthlyExpenses {

    public static void main(String[] args) {
        String newspapers = "";
        double price = 0;

        /**
         * Enter month and year in below format
         * MM/yyyy
         *
         * Example : For march'2020
         * 03/2020
         */
        System.out.println("Enter subscription month and Year in below format and press enter\n" + "Example : 03/2020");
        Scanner sc = new Scanner(System.in);
        String monthYear = sc.nextLine();

        System.out.println("Enter no of papers you want to subscribe and press enter");
        int papersCount = sc.nextInt();

        /**
         * Add newspaper names in the array
         */
        System.out.println("Enter newspaper names in new line (press enter after entering each newspaper name)\n" + "Ex:\n" + "toi\n" + "Hindu");
        String[] newspaperNames = new String[papersCount];
        for (int i = 0 ; i < papersCount; i++){
            newspaperNames[i] = sc.next();
        }
        System.out.println("Calculating the monthly expenses please wait.....");

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
            newspapers = newspaperNames[i].toUpperCase() + ", " + newspapers;
        }
        DecimalFormat df = new DecimalFormat(".00");
        System.out.println("You are subscribing " + newspapers + " newspapers and monthly charges : " + df.format(price) + "/- for " + calendar.getMonthName() + " month");
    }
}
