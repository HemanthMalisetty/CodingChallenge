package com.monthly_expenses;


import com.util.calendar.MyCalendar;

public class CalculateMonthlyExpenses {
    public static void main(String[] args) {
        int lastDateOfTheMonth = MyCalendar.getLastDateOfTheMonth();
        for (int i = 1; i <= lastDateOfTheMonth; i++){
            System.out.println(MyCalendar.getDay(i));
        }
    }
}
