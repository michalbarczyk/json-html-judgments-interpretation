package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.Utils;
import com.michalbarczyk.judgmentapp.data.Item;

import java.util.*;

/**
 * Class responsible for VII element from the features list
 */

public class MonthStats extends BasicConsoleStats {

    private final String NAME = "months";
    private final String HELP = "prints number of judgments per months";
    private Map<String, Integer> qtyPerMonth;
    private List<Map.Entry<String, Integer>> qtyPerMonthList;

    public MonthStats(RawDataKeeper rawDataKeeper) {

        super(rawDataKeeper);
        qtyPerMonth = new HashMap<>();
        qtyPerMonthList = new ArrayList<>();
    }

    private void calculate() {

        for (Item item : rawDataKeeper.getItems().values()) {

            String YYYYMM = Utils.extractYYYYMM(item.getJudgmentDate());

            if (qtyPerMonth.containsKey(YYYYMM))
                qtyPerMonth.put(YYYYMM, qtyPerMonth.remove(YYYYMM) + 1);
            else
                qtyPerMonth.put(YYYYMM, 1);
        }

        this.qtyPerMonthList.addAll(qtyPerMonth.entrySet());
        Collections.sort(qtyPerMonthList, Map.Entry.comparingByKey());
    }

    @Override
    public String getResult() {

        if (this.result == null) {

            calculate();

            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, Integer> entry : qtyPerMonthList) {

                result.append(entry.getKey());
                result.append(": ");
                result.append(entry.getValue());
                result.append(" judgment(s)\n");

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
