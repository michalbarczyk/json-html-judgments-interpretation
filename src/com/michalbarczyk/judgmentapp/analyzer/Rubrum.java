package com.michalbarczyk.judgmentapp.analyzer;

import com.michalbarczyk.judgmentapp.data.Item;
import com.michalbarczyk.judgmentapp.data.Judge;

/**
 * Class responsible for II and IV elements from the features list
 */

public class Rubrum implements IConsoleInfo {

    private final String NAME = "rubrum";
    private final String HELP = "prints rubrum(s) by signature(s)";
    private RawDataKeeper rawDataKeeper;

    public Rubrum(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
    }

    private  StringBuilder createRubrum(Item item) {

        StringBuilder result = new StringBuilder();

        result.append("------------------------------\n");

        result.append("Signature: ");
        result.append(item.getCourtCases().get(0).getCaseNumber());
        result.append("\n");

        result.append("Date: ");
        result.append(item.getJudgmentDate());
        result.append("\n");

        result.append("Court type: ");
        result.append(item.getCourtType());
        result.append("\n");

        result.append("Judges: \n");

        for (Judge judge : item.getJudges()) {
            result.append("   ");
            result.append(judge.getName());
            result.append(": ");
            result.append(judge.getSpecialRoles().toString());

            result.append("\n");
        }

        result.append("------------------------------\n");

        return result;
    }

    @Override
    public String getResult(String[] args) {

        StringBuilder result = new StringBuilder();

        if (args.length < 2)
            return result.append("at least 1 argument needed").toString();

        for (int i = 1; i < args.length; i++) {

            Item item = rawDataKeeper.getItems().get(args[i]);

            if (item == null) {
                result.append("there is not judgment: \"");
                result.append(args[i]);
                result.append("\"\n");
            }
            else {
                result.append(createRubrum(item));
            }

            result.append("\n");

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
