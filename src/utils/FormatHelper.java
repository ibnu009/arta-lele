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
import java.util.logging.Level;
import java.util.logging.Logger;

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
