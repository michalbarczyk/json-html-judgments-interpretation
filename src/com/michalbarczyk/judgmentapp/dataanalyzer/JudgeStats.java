package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.Judge;

import java.util.*;

public class JudgeStats { // V element from features list

    private RawDataKeeper rawDataKeeper;
    private Map<Judge, Integer> qtyPerJudge;

    public JudgeStats(RawDataKeeper rawDataKeeper) {
        this.rawDataKeeper = rawDataKeeper;
        this.qtyPerJudge = new HashMap<>();
        calculateStats();
    }

    private void calculateStats() {

        for (Item item : rawDataKeeper.getItems().values()) {

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

    public void printItemsQtyByJudgeName(String judgeName) {

        System.out.println("Quantity of their cases = " + getItemsQtyByJudgeName(judgeName));
    }

}
