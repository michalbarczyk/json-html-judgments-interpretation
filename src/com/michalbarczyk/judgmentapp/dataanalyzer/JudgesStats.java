package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.*;

public class JudgesStats {

    private DataKeeper dataKeeper;
    private Map<Judge, Integer> qtyPerJudge;

    public JudgesStats(DataKeeper dataKeeper) {
        this.dataKeeper = dataKeeper;
        this.qtyPerJudge = new HashMap<>();
        calculateStats();
    }

    private void calculateStats() {

        for (Item item : dataKeeper.getItems().values()) {

            for (Judge judge : item.getJudges()) {

                if (qtyPerJudge.containsKey(judge))
                    qtyPerJudge.put(judge, qtyPerJudge.remove(judge) + 1);
                else
                    qtyPerJudge.put(judge, 1);
            }
        }

    }

    public Integer getItemsQtyByJudgeName(String judgeName) {

        Judge judge = new Judge();
        judge.setName(judgeName);
        return qtyPerJudge.get(judge);
    }

    public Integer getItemsQtyByJudge(Judge judge) {

        return qtyPerJudge.get(judge);

    }

    /*public List<Judge> getTop10Judges {

        //Collection<Map.Entry<Judge, Integer>> collection = qtyPerJudge.entrySet();
        //Collections.s
    }*/



    public void printAll () {

        int n = 0;
        for (Map.Entry<Judge,Integer> stat : qtyPerJudge.entrySet()) {

            System.out.println(++n + ": Judge " + stat.getKey().getName() + " contributed to " + stat.getValue() + " judgments");
        }
    }

}
