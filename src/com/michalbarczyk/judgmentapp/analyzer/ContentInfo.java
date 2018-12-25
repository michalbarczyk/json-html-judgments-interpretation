package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;

/**
 * Class responsible for III element from the features list
 */

public class ContentInfo implements IConsoleInfo {

    private final String NAME = "content";
    private final String HELP = "prints content by signature";
    private RawDataKeeper rawDataKeeper;

    public ContentInfo(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
    }

    @Override
    public String getResult(String[] args) {

        StringBuilder result = new StringBuilder();

        if (args.length < 2)
            return result.append("1 argument needed").toString();

        Item item = rawDataKeeper.getItems().get(args[1]);

        if (item == null) {
            result.append("there is not judgment: \"");
            result.append(args[1]);
            result.append("\"\n");
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
