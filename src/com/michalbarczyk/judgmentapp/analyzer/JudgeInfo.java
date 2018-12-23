package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;
import com.michalbarczyk.judgmentapp.data.Judge;
import java.util.*;

/**
 * Class responsible for V element from the features list
 */

public class JudgeInfo implements IConsoleInfo {

    private final String NAME = "judge";
    private final String HELP = "prints number of judgments a judge participated in";
    private RawDataKeeper rawDataKeeper;
    private Map<Judge, Integer> qtyPerJudge;
    private boolean calculated;

    public JudgeInfo(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        this.qtyPerJudge = new HashMap<>();
        this.calculated = false;
    }

    private void calculate() {

        for (Item item : rawDataKeeper.getItems().values()) {

            for (Judge judge : item.getJudges()) {

                if (qtyPerJudge.containsKey(judge))
                    qtyPerJudge.put(judge, qtyPerJudge.remove(judge) + 1);
                else
                    qtyPerJudge.put(judge, 1);
            }
        }

        calculated = true;
    }

    public Map<Judge, Integer> getQtyPerJudge() {

        if (!calculated)
            calculate();

        return qtyPerJudge;
    }

    @Override
    public String getResult(String[] args) {

        Judge judge = new Judge(args[1]);

        return getResultByJudge(judge).toString();
    }

    StringBuilder getResultByJudge(Judge judge) {

        if (!calculated)
            calculate();

        StringBuilder result = new StringBuilder();
        Integer judgeQty = qtyPerJudge.get(judge);

        if (judgeQty == null) {
            result.append("there is not judge named ");
            result.append(judge.getName());
            result.append("\n");
        }
        else {
            result.append("------------------------------\n");
            result.append(judge.getName());
            result.append(" participated in ");
            result.append(judgeQty);
            result.append(" judgments\n");
            result.append("------------------------------\n");
        }

        return result;
    }



    public String getName() {

        return this.NAME;
    }

    public String getHelp() {

        return this.HELP;
    }
}
