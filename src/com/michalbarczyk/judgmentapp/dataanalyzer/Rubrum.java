package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.CourtCase;
import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.objectrep.Judge;

import java.util.List;

public class Rubrum {

    private CourtCase courtCase;
    private String date;
    private String courtType;
    private List<Judge> judges;

    public Rubrum(Item item) {

        this.courtCase = item.getCourtCases().get(0);
        this.date = item.getJudgmentDate();
        this.courtType = item.getCourtType();
        this.judges = item.getJudges();
    }

    public void print() {

        System.out.println("Signature: " + courtCase.getCaseNumber());
        System.out.println("Date: " + date);
        System.out.println("Court type: " + courtType);
        System.out.println("Judges:");
        for (Judge judge : judges) {
            System.out.print(" " + judge.getName());
        }
    }





}
