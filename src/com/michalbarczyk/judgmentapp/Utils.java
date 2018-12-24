package com.michalbarczyk.judgmentapp;

import com.michalbarczyk.judgmentapp.data.Judge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    /**
     *
     * @param dateStr
     * @return array [YYYY, MM, DD] from dateStr YYYY-MM-DD
     */
    public static String[] parseDate(String dateStr) {

        String delims = "-";
        String[] tokens = dateStr.split(delims);

        return tokens;
    }

    public static String[] parseLineBy(String line, String delims) {

        String[] tokens = line.split(delims);

        return tokens;
    }

    /**
     *
     * @param dateStr
     * @return year, month of strDate as YYYY-MM
     */
    public static String extractYYYYMM(String dateStr) {

        String[] tokens = parseDate(dateStr);
        return tokens[0] + "-" + tokens[1];

    }
}
