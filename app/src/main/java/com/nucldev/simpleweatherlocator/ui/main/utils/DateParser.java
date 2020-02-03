package com.nucldev.simpleweatherlocator.ui.main.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateParser {
    private String date;

    public DateParser(String date) {
        this.date = date;
    }

    public String getDateAndDayOfWeek(){
        String[] arr1 = this.date.split("-");
        int year = Integer.parseInt(arr1[0]);
        int month = Integer.parseInt(arr1[1]);
        String[] arr2 = arr1[2].split(" ");
        int date = Integer.parseInt(arr2[0]);
        String[] arr3 = arr2[1].split(":");
        int hour = Integer.parseInt(arr3[0]);

        Calendar calendar = new GregorianCalendar(year, month-1, date, hour, 0);
        Calendar calendar1 = new GregorianCalendar();
        String dateAndDayOfWeek = "";
        if (calendar.get(Calendar.DATE)==calendar1.get(Calendar.DATE) & calendar.get(Calendar.MONTH)==calendar1.get(Calendar.MONTH) & calendar.get(Calendar.YEAR)==calendar1.get(Calendar.YEAR)){
            dateAndDayOfWeek = "Today";
        } else {
            if (calendar.get(Calendar.DAY_OF_WEEK)==1)
                dateAndDayOfWeek = "Sunday";
            if (calendar.get(Calendar.DAY_OF_WEEK)==2)
                dateAndDayOfWeek = "Monday";
            if (calendar.get(Calendar.DAY_OF_WEEK)==3)
                dateAndDayOfWeek = "Tuesday";
            if (calendar.get(Calendar.DAY_OF_WEEK)==4)
                dateAndDayOfWeek = "Wednesday";
            if (calendar.get(Calendar.DAY_OF_WEEK)==5)
                dateAndDayOfWeek = "Thursday";
            if (calendar.get(Calendar.DAY_OF_WEEK)==6)
                dateAndDayOfWeek = "Friday";
            if (calendar.get(Calendar.DAY_OF_WEEK)==7)
                dateAndDayOfWeek = "Saturday";
            if (calendar.get(Calendar.MONTH)==0)
                dateAndDayOfWeek += " Jan";
            if (calendar.get(Calendar.MONTH)==1)
                dateAndDayOfWeek += " Feb";
            if (calendar.get(Calendar.MONTH)==2)
                dateAndDayOfWeek += " Mar";
            if (calendar.get(Calendar.MONTH)==3)
                dateAndDayOfWeek += " Apr";
            if (calendar.get(Calendar.MONTH)==4)
                dateAndDayOfWeek += " May";
            if (calendar.get(Calendar.MONTH)==5)
                dateAndDayOfWeek += " Jun";
            if (calendar.get(Calendar.MONTH)==6)
                dateAndDayOfWeek += " Jul";
            if (calendar.get(Calendar.MONTH)==7)
                dateAndDayOfWeek += " Aug";
            if (calendar.get(Calendar.MONTH)==8)
                dateAndDayOfWeek += " Sep";
            if (calendar.get(Calendar.MONTH)==9)
                dateAndDayOfWeek += " Oct";
            if (calendar.get(Calendar.MONTH)==10)
                dateAndDayOfWeek += " Nov";
            if (calendar.get(Calendar.MONTH)==11)
                dateAndDayOfWeek += " Dec";

            dateAndDayOfWeek +=  ", "+calendar.get(Calendar.DATE);
        }
        return dateAndDayOfWeek;
    }

    public String getTime(){
        String[] arr1 = this.date.split("-");
        int year = Integer.parseInt(arr1[0]);
        int month = Integer.parseInt(arr1[1]);
        String[] arr2 = arr1[2].split(" ");
        int date = Integer.parseInt(arr2[0]);
        String[] arr3 = arr2[1].split(":");
        int hour = Integer.parseInt(arr3[0]);


        String time ="";
        time += hour+":00";
        return time;
    }
}
