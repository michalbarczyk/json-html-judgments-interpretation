package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Item;

public class Content implements IConsoleInfo {

    private final String NAME = "content";
    private final String HELP = "prints content by signature";
    private RawDataKeeper rawDataKeeper;

    public Content(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
    }

    @Override
    public String getResult(String[] args) {

        StringBuilder result = new StringBuilder();
        Item item = rawDataKeeper.getItems().get(args[1]);

        if (item == null) {
            result.append("there is not judgment: ");
            result.append(args[1]);
            result.append("\n");
        }
        else {
            result.append("------------------------------\n");
            result.append(item.getTextContent());
            result.append("\n");
            result.append("------------------------------\n");
        }

        return result.toString();

    }

    @Override
    public String getName() {

        return this.NAME;
    }

    @Override
    public String getHelp() {

        return this.HELP;
    }
}
