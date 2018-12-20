package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Judge;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class responsible for VI element from the features list TODO
 */

/*
public class BestJudgesStats extends BasicConsoleStats  {

    private final String NAME = "judges";
    private final String HELP = "prints " + TOPSIZE + " most active judges";
    private List<Map.Entry<String, Integer>> top;
    private static final int TOPSIZE = 10;
    private JudgeStats judgeStats;

    public BestJudgesStats(RawDataKeeper rawDataKeeper) {

        super(rawDataKeeper);
        this.top = new ArrayList<>();
        judgeStats = new JudgeStats(rawDataKeeper);
    }

    private void calculate() {

        for (int i = 0; i < TOPSIZE; i++) {

            if (judgeStats.getQtyPerJudge().isEmpty()) break;
            Map.Entry<String, Integer> maxEntry = null;

            for (Map.Entry<String, Integer> entry : judgeStats.getQtyPerJudge().entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            top.add(maxEntry);
            judgeStats.getQtyPerJudge().remove(maxEntry.getKey());
        }

    }

    public String getResult() {

        if (this.result == null) {

            calculate();

            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, Integer> entry : judgeStats.getQtyPerJudge().entrySet()) {

                result.append()
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

*/