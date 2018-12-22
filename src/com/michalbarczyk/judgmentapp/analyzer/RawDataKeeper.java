package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;
import com.michalbarczyk.judgmentapp.data.JudgmentsPack;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class responsible for keeping data possessed from JSON files containing Judgments(Items)
 */

public class RawDataKeeper {

    private List<JudgmentsPack> judgmentsPacks; //original structure as it was in JSON files
    private Map<String, Item> items; // all judgments from JSON files


    public RawDataKeeper(List<JudgmentsPack> judgmentsPacks) {

        this.judgmentsPacks = judgmentsPacks;
        items = new HashMap<>();

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                items.put(item.getCourtCases().get(0).getCaseNumber(), item);
            }
        }
    }

    public Map<String, Item> getItems() {
        return this.items;
    }

    /*public Rubrum getRubrumBySignature(String signature) {

        for (Item item : items.values()) {

            if(item.getCourtCases().get(0).equals(signature))
                return new Rubrum(item);

        }
    }*/






}
