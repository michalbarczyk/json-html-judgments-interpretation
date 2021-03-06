package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for VIII element from the features list
 */

public class CourtTypeStats extends BasicConsoleStats {

    private Map<String, Integer> qtyPerCourtType;
    private final String NAME = "courts";
    private final String HELP = "prints amount of judgments per court type";

    public CourtTypeStats(RawDataKeeper rawDataKeeper) {

        super(rawDataKeeper);
        this.qtyPerCourtType = new HashMap<>();

    }

    private void calculate() {

        for (Item item : rawDataKeeper.getItems().values()) {

            String key = item.getCourtType();
            if (qtyPerCourtType.containsKey(key))
                qtyPerCourtType.put(key, qtyPerCourtType.remove(key) + 1);
            else
                qtyPerCourtType.put(key, 1);
        }
    }

    public String getResult() {

        if (this.result == null) {

            calculate();

            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, Integer> entry : qtyPerCourtType.entrySet()) {

                result.append("There were ");
                result.append(entry.getValue());
                result.append(" judgments in ");
                result.append(entry.getKey());
                if (!entry.getKey().equals("CONSTITUTIONAL_TRIBUNAL") &&
                    !entry.getKey().equals("NATIONAL_APPEAL_CHAMBER"))
                        result.append(" court\n");
                else result.append("\n");
            }

            this.result = result.toString();
        }

        return this.result;
    }

    public String getName() {

        return this.NAME;
    }

    public String getHelp() {

        return this.HELP;
    }
}
