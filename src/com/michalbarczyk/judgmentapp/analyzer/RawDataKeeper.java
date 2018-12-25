package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;
import java.util.Map;

/**
 * Class responsible for keeping data possessed from JSON/HTML files
 * containing Judgments (named also as Items)
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
