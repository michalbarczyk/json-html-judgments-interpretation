package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;
import com.michalbarczyk.judgmentapp.data.ReferencedRegulation;
import java.util.*;

/**
 * Class responsible for IX element from the features list
 */

public class RegulationStats extends BasicConsoleStats {

    private final String NAME = "regulations";
    private final String HELP = "prints " + TOPSIZE + " most often referenced regulations";
    private List<Map.Entry<ReferencedRegulation, Integer>> top;
    private static final int TOPSIZE = 10;

    public RegulationStats(RawDataKeeper rawDataKeeper) {

        super(rawDataKeeper);
        this.top = new ArrayList<>();
    }

    private void calculate() {

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

    @Override
    public String getResult() {

        if (this.result == null) {

            calculate();

            StringBuilder result = new StringBuilder();

            for (Map.Entry<ReferencedRegulation, Integer> entry : top) {

                result.append(top.indexOf(entry) + 1);
                result.append(": ");
                result.append(entry.getKey().getJournalTitle());
                result.append(" was referenced ");
                result.append(entry.getValue());
                result.append(" time(s)\n");

            }

            this.result = result.toString();
        }

        return this.result;
    }

    @Override
    public String getName() {

        return this.NAME;
    }

    @Override
    public String getHelp() {

        return this.HELP;
    }
}
