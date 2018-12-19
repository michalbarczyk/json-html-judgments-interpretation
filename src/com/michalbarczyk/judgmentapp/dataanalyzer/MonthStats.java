package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.Utils;
import com.michalbarczyk.judgmentapp.objectrep.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for VII element from the features list
 */

public class MonthStats /*implements IStats*/ {

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
