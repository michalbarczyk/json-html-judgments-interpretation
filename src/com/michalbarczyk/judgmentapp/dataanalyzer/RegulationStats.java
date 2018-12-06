package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.ReferencedRegulation;
import java.util.*;

/**
 * Class responsible for IX element from the features list
 */

public class RegulationStats implements IStats { // IX element from features list

    private RawDataKeeper rawDataKeeper;
    private List<Map.Entry<ReferencedRegulation, Integer>> top;
    private static final int TOPSIZE = 10;

    public RegulationStats(RawDataKeeper rawDataKeeper) {
        this.rawDataKeeper = rawDataKeeper;
        this.top = new ArrayList<>();
        calculateTop();
    }

    private void calculateTop() {

        Map<ReferencedRegulation, Integer> qtyPerRegulation = new HashMap<>();

        for (Item item : rawDataKeeper.getItems().values()) {

            for (ReferencedRegulation rR : item.getReferencedRegulations()) {

                if (qtyPerRegulation.containsKey(rR))
                    qtyPerRegulation.put(rR, qtyPerRegulation.remove(rR) + 1);
                else
                    qtyPerRegulation.put(rR, 1);
            }
        }

        for (int i = 0; i < TOPSIZE; i++) {

            if (qtyPerRegulation.isEmpty()) break;
            Map.Entry<ReferencedRegulation, Integer> maxEntry = null;

            for (Map.Entry<ReferencedRegulation, Integer> entry : qtyPerRegulation.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            top.add(maxEntry);
            qtyPerRegulation.remove(maxEntry.getKey());

        }

    }

    private List<Map.Entry<ReferencedRegulation, Integer>> getTop() {

        return this.top;
    }

    public void print() {

        for (Map.Entry<ReferencedRegulation, Integer> entry : top) {

            System.out.println((getTop().indexOf(entry) + 1) + ": " + entry.getKey().getJournalTitle() +
                    " was referenced " + entry.getValue() + " time(s)");
        }
    }
}
