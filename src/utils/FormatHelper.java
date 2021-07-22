/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ibnub
 */
public class FormatHelper {
    
    public String formatNumberToThousand(int value) {
        String formatedValue = NumberFormat.getIntegerInstance().format(value);
        return "Rp." + formatedValue;
    }
    
    public String getTodayDate() {
        Date date = (Date) Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = dateFormat.format(date);
        
        return strDate;
    }
    
    public String getCurrentMonth() {
        int month;
        GregorianCalendar date = new GregorianCalendar();
        month = date.get(Calendar.MONTH);
        month = month + 1;
        System.out.println("Current month is  " + month);
        
        return monthToString(month);
    }
    
    private String monthToString(int value) {
        String bulan = "";
        switch (value) {
            case 1:
                bulan = "January";
                break;
            case 2:
                bulan = "February";
                break;
            case 3:
                bulan = "March";
                break;
            case 4:
                bulan = "April";
                break;
            case 5:
                bulan = "May";
                break;
            case 6:
                bulan = "June";
                break;
            case 7:
                bulan = "July";
                break;
            case 8:
                bulan = "August";
                break;
            case 9:
                bulan = "September";
                break;
            case 10:
                bulan = "October";
                break;
            case 11:
                bulan = "November";
                break;
            case 12:
                bulan = "December";
                break;
            default:
            // code block
        }
        
        return bulan;
    }
    
    public Date convertStringToDate(String date) throws ParseException {
        Date rDate;
        
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        
        rDate = oldDateFormat.parse(date);
        
        return rDate;
    }
    
    public String convertDateToProperDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = dateFormat.format(date);
        
        return strDate;
    }
    
    public int convertBeratToInteger(String berat) {
        int weight;
        
        String rawBerat = berat.replaceAll("\\D+", "");
        weight = Integer.parseInt(rawBerat);
        
        return weight;
    }
    
    public String extractNumberFromString(String value) {
        String newValue;
        newValue = value.replaceAll("\\D+", "");
        
        return newValue;
    }
}
