package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataKeeper {

    private List<JudgmentsPack> judgmentsPacks; //original structure as it was in JSON files
    private Map<Integer, Item> items; // all judgments from JSON files
    private CourtTypeStats courtTypeStats;

    public DataKeeper(List<JudgmentsPack> judgmentsPacks) {

        this.judgmentsPacks = judgmentsPacks;
        items = new HashMap<>();

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                items.put(item.getId(), item);
            }
        }

        courtTypeStats = new CourtTypeStats(this);
    }

    public CourtTypeStats getCourtTypeStats() {
        return courtTypeStats;
    }

    public Map<Integer, Item> getItems() {
        return this.items;
    }

    public Map<Integer, Integer> getStatsJudgesPerJudgment() {

        Map<Integer, Integer> stats = new HashMap<>();

        for (Item item : items.values()) {

            Integer key = item.getJudges().size();
            if (stats.containsKey(key))
                stats.put(key, stats.remove(key) + 1);
            else
                stats.put(key, 1);
        }

        return stats;
    }













}
