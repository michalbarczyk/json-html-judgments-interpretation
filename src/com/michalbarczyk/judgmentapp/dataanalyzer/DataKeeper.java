package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataKeeper {

    private List<JudgmentsPack> judgmentsPacks; //original structure as it was in JSON files
    private Map<String, Item> judgments;

    public DataKeeper(List<JudgmentsPack> judgmentsPacks) {

        this.judgmentsPacks = judgmentsPacks;
        judgments = new HashMap<>();

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                judgments.put(item.getCourtCases().get(0).getCaseNumber()+
                        item.getJudgmentDate(), item);
            }
        }

        int i = 0;
        for (Item item : judgments.values()) {
            System.out.println(++i + " " + item.getId());
        }
    }

    public static String generateKey(Item item) { //useless

        StringBuilder key = new StringBuilder();

        key.append(item.getReferencedRegulations().get(0).getJournalNo());
        key.append(item.getReferencedRegulations().get(0).getJournalYear());
        key.append(item.getReferencedRegulations().get(0).getJournalEntry());

        return key.toString();
    }

    /*public String getRubrum(String caseNumber) {


    }*/






}
