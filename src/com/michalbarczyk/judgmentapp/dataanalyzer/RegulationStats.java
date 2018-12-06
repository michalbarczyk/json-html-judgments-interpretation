package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.ReferencedRegulation;

import java.util.*;

public class RegulationStats { // IX element from features list

    private RawDataKeeper rawDataKeeper;
    private List<ReferencedRegulation> top10;

    public RegulationStats(RawDataKeeper rawDataKeeper) {
        this.rawDataKeeper = rawDataKeeper;
        this.top10 = new ArrayList<>();
        calculateStats();
    }

    private void calculateStats() {

        Map<ReferencedRegulation, Integer> qtyPerRegulation = new HashMap<>();

        for (Item item : rawDataKeeper.getItems().values()) {

            for (ReferencedRegulation rR : item.getReferencedRegulations()) {

                if (qtyPerRegulation.containsKey(rR))
                    qtyPerRegulation.put(rR, qtyPerRegulation.remove(rR) + 1);
                else
                    qtyPerRegulation.put(rR, 1);
            }
        }

        for (int i = 0; i < 10; i++) { // to be optimized

            Map.Entry<ReferencedRegulation, Integer> maxEntry = null;

            for (Map.Entry<ReferencedRegulation, Integer> entry : qtyPerRegulation.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            top10.set(i, maxEntry.getKey());
        }

    }

    private List<ReferencedRegulation> getTop10() {

        return this.top10;
    }

    public void print() {

        for (int i = 0; i < 10; i++) {

            System.out.println(i+1 + ": " + getTop10().get(i).getJournalTitle());
        }
    }
}
