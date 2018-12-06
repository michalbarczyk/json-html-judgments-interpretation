package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.michalbarczyk.judgmentapp.dataanalyzer.Utils.parseDate;

public class MonthStats {

    private RawDataKeeper rawDataKeeper;
    private Map<String, Integer> qtyPerMonth;

    public MonthStats(RawDataKeeper rawDataKeeper) {
        this.rawDataKeeper = rawDataKeeper;
        qtyPerMonth = new HashMap<>();
        calculateStats();
    }


    private void calculateStats() {

        for (Item item : rawDataKeeper.getItems().values()) {

            String YYYYMM = Utils.extractYYYYMM(item.getJudgmentDate());

            if (qtyPerMonth.containsKey(YYYYMM))
                qtyPerMonth.put(YYYYMM, qtyPerMonth.remove(YYYYMM) + 1);
            else
                qtyPerMonth.put(YYYYMM, 1);
        }
    }


    public Map getStats() {

        return qtyPerMonth;
    }

    public void print() {

        for (Map.Entry<String, Integer> entry : qtyPerMonth.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue() + " judgment(s)");
        }
    }

}
