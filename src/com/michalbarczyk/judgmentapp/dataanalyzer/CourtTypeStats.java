package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for VIII element from the features list
 */

public class CourtTypeStats implements IStats {

    private RawDataKeeper rawDataKeeper;
    private Map<String, Integer> qtyPerCourtType;

    public CourtTypeStats(RawDataKeeper rawDataKeeper) {
        this.rawDataKeeper = rawDataKeeper;
        this.qtyPerCourtType = new HashMap<>();
        calculateStats();
    }

    private void calculateStats() {

        for (Item item : rawDataKeeper.getItems().values()) {

            String key = item.getCourtType();
            if (qtyPerCourtType.containsKey(key))
                qtyPerCourtType.put(key, qtyPerCourtType.remove(key) + 1);
            else
                qtyPerCourtType.put(key, 1);
        }

    }

    private Map<String, Integer> getQtyPerCourtType() {

        return this.qtyPerCourtType;
    }

    public void print() {

        for (Map.Entry<String, Integer> entry : qtyPerCourtType.entrySet()) {

            System.out.println("There were " + entry.getValue()
                    + " judgments in " + entry.getKey() + " court");

        }
    }
}
