package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.michalbarczyk.judgmentapp.objectrep.Converter;
import com.michalbarczyk.judgmentapp.objectrep.Item;
import com.michalbarczyk.judgmentapp.ui.ConsoleInterpreter;

import java.io.File;
import java.io.IOException;

public class Tests {

    public static void main(String[] args) {

        try {

            RawDataKeeper dK = new RawDataKeeper(Converter.convertAll(new File("C:\\Users\\Michał Barczyk\\Desktop\\json\\json")));


            for(Item item : dK.getItems().values()) {

                System.out.println(item.getJudgmentDate() + " -> " + Utils.extractYYYYMM(item.getJudgmentDate()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
