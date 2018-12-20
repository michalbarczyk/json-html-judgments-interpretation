package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.Judge;
import java.util.*;

/**
 * Class responsible for V element from the features list
 */

public class JudgeStats implements IConsoleInfo{

    private final String NAME = "judge";
    private final String HELP = "prints number of judgments a judge participated in";
    private RawDataKeeper rawDataKeeper;
    private Map<String, Integer> qtyPerJudge;
    private boolean calculated;

    public JudgeStats(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        this.qtyPerJudge = new HashMap<>();
        this.calculated = false;
    }

    private void calculate() {

        for (Item item : rawDataKeeper.getItems().values()) {

            for (Judge judge : item.getJudges()) {

                if (qtyPerJudge.containsKey(judge))
                    qtyPerJudge.put(judge.getName(), qtyPerJudge.remove(judge) + 1);
                else
                    qtyPerJudge.put(judge.getName(), 1);
            }
        }

        calculated = true;
    }

    public Map<String, Integer> getQtyPerJudge() {

        if (!calculated)
            calculate();

        return qtyPerJudge;
    }

    @Override
    public String getResult(String[] args) {

        if (!calculated)
            calculate();

        StringBuilder result = new StringBuilder();
        Integer judgeQty = qtyPerJudge.get(args[1]);

        if (judgeQty == null) {
            result.append("there is not judge named ");
            result.append(args[1]);
            result.append("\n");
        }
        else {
            result.append("------------------------------\n");
            result.append(args[1]);
            result.append(" participated in ");
            result.append(judgeQty);
            result.append(" judgments\n");
            result.append("------------------------------\n");
        }

        return result.toString();
    }

    public String getName() {

        return this.NAME;
    }

    public String getHelp() {

        return this.HELP;
    }
}
