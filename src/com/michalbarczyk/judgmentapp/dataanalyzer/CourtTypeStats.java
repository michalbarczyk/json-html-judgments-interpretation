package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.HashMap;
import java.util.Map;

public class CourtTypeStats {

    private DataKeeper dataKeeper;
    private Map<String, Integer> qtyPerCourtType;

    public CourtTypeStats(DataKeeper dataKeeper) {
        this.dataKeeper = dataKeeper;
        this.qtyPerCourtType = new HashMap<>();
        calculateStats();
    }

    private void calculateStats() {

        for (Item item : dataKeeper.getItems().values()) {

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

    public void printStats() {

        for (Map.Entry<String, Integer> entry : qtyPerCourtType.entrySet()) {

            System.out.println("There were " + entry.getValue()
                    + " judgments in " + entry.getKey() + " court");

        }
    }





}
