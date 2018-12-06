package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.JudgmentsPack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawDataKeeper {

    private List<JudgmentsPack> judgmentsPacks; //original structure as it was in JSON files
    private Map<Integer, Item> items; // all judgments from JSON files


    public RawDataKeeper(List<JudgmentsPack> judgmentsPacks) {

        this.judgmentsPacks = judgmentsPacks;
        items = new HashMap<>();

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                items.put(item.getId(), item);
            }
        }
    }

    public Map<Integer, Item> getItems() {
        return this.items;
    }

    /*public Rubrum getRubrumBySignature(String signature) {

        for (Item item : items.values()) {

            if(item.getCourtCases().get(0).equals(signature))
                return new Rubrum(item);

        }
    }*/






}