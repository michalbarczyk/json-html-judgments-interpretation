package com.michalbarczyk.judgmentapp;

import com.michalbarczyk.judgmentapp.analyzer.RawDataKeeper;
//import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.data.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.util.*;



// FOR TEST PURPOSE ONLY // FOR TEST PURPOSE ONLY // FOR TEST PURPOSE ONLY

public class TrainingArea {

    public static void main(String[] args) {

        try {

            Converter converter = new Converter();
            RawDataKeeper dK = new RawDataKeeper(converter.convertAll(new File("C:\\Users\\Michał Barczyk\\Desktop\\Judgments")));

            for (Item item : dK.getItems().values()) {

                if (item.getJudges() == null || item.getReferencedRegulations() == null) {

                    System.out.println(item.getCourtCases().get(0).getCaseNumber());
                }
            }


        } catch (IOException e) {

        }

    }

}
