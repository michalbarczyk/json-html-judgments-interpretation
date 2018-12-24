package com.michalbarczyk.judgmentapp;

import com.michalbarczyk.judgmentapp.analyzer.BestJudgesStats;
import com.michalbarczyk.judgmentapp.analyzer.JudgeInfo;
import com.michalbarczyk.judgmentapp.analyzer.RawDataKeeper;
//import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.data.Item;
import com.michalbarczyk.judgmentapp.data.Judge;
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
            JudgeInfo judgeInfo = new JudgeInfo(dK);
            BestJudgesStats bestJudgesStats = new BestJudgesStats(dK,judgeInfo);

            for (Map.Entry<Judge, Integer> entry : judgeInfo.getQtyPerJudge().entrySet()) {

                if (entry.getKey().getName().startsWith("Janin"))
                    System.out.println(entry.getKey().getName() + ": " + entry.getValue());
            }


        } catch (IOException e) {

        }

    }

}
