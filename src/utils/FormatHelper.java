/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
