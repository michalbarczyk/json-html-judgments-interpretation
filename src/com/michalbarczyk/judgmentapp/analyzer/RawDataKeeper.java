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

    private Map<String, Item> items;

    public RawDataKeeper(Map<String, Item> items) {

        this.items = items;
    }

    public Map<String, Item> getItems() {
        return this.items;
    }





}
