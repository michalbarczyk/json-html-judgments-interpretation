package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for X element from the features list
 */

public class JudgeItemRatioStats implements IConsoleElement {

    private RawDataKeeper rawDataKeeper;
    private Map<Integer, Integer> qtyPerItem;
    private String result;
    private final String NAME = "jury";
    private final String HELP = "prints amount of judges per judgments";


    public JudgeItemRatioStats(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        this.qtyPerItem = new HashMap<>();
        result = null;
    }

    private void calculate() {

        for (Item item : rawDataKeeper.getItems().values()) {

            Integer key = item.getJudges().size();
            if (qtyPerItem.containsKey(key))
                qtyPerItem.put(key, qtyPerItem.remove(key) + 1);
            else
                qtyPerItem.put(key, 1);
        }
    }

    public String getResult() {

        if (this.result == null) {

            calculate();

            StringBuilder result = new StringBuilder();

            for (Map.Entry<Integer,Integer> entry : qtyPerItem.entrySet()) {

                result.append("There were ");
                result.append(entry.getKey());
                result.append(" judge(s) in ");
                result.append(entry.getValue());
                result.append(" judgments\n");
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
