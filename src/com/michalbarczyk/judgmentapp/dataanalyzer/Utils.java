package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.List;
import java.util.Map;

public class Utils {

    public static String[] parseDate(String dateStr) {

        String delims = "-";
        String[] tokens = dateStr.split(delims);

        return tokens;
    }

    public static String[] parseLine(String line) {

        String delims = "[ ]+";
        String[] tokens = line.split(delims);

        return tokens;
    }

    public static String extractYYYYMM(String dateStr) {

        String[] tokens = parseDate(dateStr);
        return tokens[0] + "-" +tokens[1];

    }
}
