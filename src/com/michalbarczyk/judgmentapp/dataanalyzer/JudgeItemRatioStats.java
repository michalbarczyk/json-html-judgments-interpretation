package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for X element from the features list
 */

public class JudgeItemRatioStats implements IStats {

    private RawDataKeeper rawDataKeeper;
    private Map<Integer, Integer> qtyPerItem;

    public JudgeItemRatioStats(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        this.qtyPerItem = new HashMap<>();
        calculateStats();
    }

    private void calculateStats() {

        for (Item item : rawDataKeeper.getItems().values()) {

            Integer key = item.getJudges().size();
            if (qtyPerItem.containsKey(key))
                qtyPerItem.put(key, qtyPerItem.remove(key) + 1);
            else
                qtyPerItem.put(key, 1);
        }
    }

    public void print() {

        for (Map.Entry<Integer,Integer> entry : qtyPerItem.entrySet()) {

            System.out.println("There were " + entry.getKey() + " judge(s) in " +
                    entry.getValue() + " judgments");
        }
    }
}
