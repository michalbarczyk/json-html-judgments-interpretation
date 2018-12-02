package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataKeeper {

    private List<JudgmentsPack> judgmentsPacks; //original structure as it was in JSON files
    private Map<Integer, Item> judgments;

    public DataKeeper(List<JudgmentsPack> judgmentsPacks) {

        this.judgmentsPacks = judgmentsPacks;
        judgments = new HashMap<>();

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                judgments.put(item.getId(), item);
            }
        }
    }

    public Map<Integer, Integer> getStatsJudgesPerJudgment() {

        Map<Integer, Integer> stats = new HashMap<>();

        for (Item item : judgments.values()) {

            Integer key = item.getJudges().size();
            if (stats.containsKey(key))
                stats.put(key, stats.remove(key) + 1);
            else
                stats.put(key, 1);
        }

        return stats;
    }






}
