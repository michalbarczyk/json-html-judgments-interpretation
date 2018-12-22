package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Judge;

import java.util.*;

/**
 * Class responsible for VI element from the features list
 */


public class BestJudgesStats extends BasicConsoleStats  {

    private final String NAME = "judges";
    private final String HELP = "prints " + TOPSIZE + " most active judges";
    private List<Map.Entry<Judge, Integer>> qtyPerJudgeList;
    private static final int TOPSIZE = 10;
    private JudgeStats judgeStats;

    public BestJudgesStats(RawDataKeeper rawDataKeeper, JudgeStats judgeStats) {

        super(rawDataKeeper);
        this.judgeStats = judgeStats;
        this.qtyPerJudgeList = null;
    }

    private void calculate() {

        qtyPerJudgeList = new ArrayList(judgeStats.getQtyPerJudge().entrySet());

        Collections.sort(qtyPerJudgeList, Map.Entry.comparingByValue());

        Collections.reverse(qtyPerJudgeList);



        /*for (int i = 0; i < TOPSIZE; i++) {

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
        }*/


    }



    public String getResult() {

        if (this.result == null) {

            calculate();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < TOPSIZE; i++) {

                result.append(i + 1);
                result.append(": \n");
                result.append(judgeStats.getResultByJudge(qtyPerJudgeList.get(i).getKey()));
                result.append("\n");
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
