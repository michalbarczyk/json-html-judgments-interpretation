package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.Judge;
import com.michalbarczyk.judgmentapp.objectrep.ReferencedRegulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestJudgesStats extends JudgeStats {

    private List<Map.Entry<Judge, Integer>> top;
    private static final int TOPSIZE = 10;

    public BestJudgesStats(RawDataKeeper rawDataKeeper) {

        super(rawDataKeeper);
        super.calculateStats();
        this.top = new ArrayList<>();
        this.calculateTop();
    }

    private void calculateTop() {

        for (int i = 0; i < TOPSIZE; i++) { // to be optimized

            if (getQtyPerJudge().isEmpty()) break;
            Map.Entry<Judge, Integer> maxEntry = null;

            for (Map.Entry<Judge, Integer> entry : getQtyPerJudge().entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            top.add(maxEntry);
            getQtyPerJudge().remove(maxEntry.getKey());
        }

    }

    private List<Map.Entry<Judge, Integer>> getTop() {

        return this.top;
    }

    public void print() {

        for (Map.Entry<Judge, Integer> entry : top) {

            System.out.println((getTop().indexOf(entry) + 1) + ": " + entry.getKey().getName() +
                    " participated in " + entry.getValue() + " judgment(s)");
        }
    }
}
