package com.michalbarczyk.judgmentapp;

import com.michalbarczyk.judgmentapp.dataanalyzer.RawDataKeeper;
import com.michalbarczyk.judgmentapp.objectrep.Converter;
import com.michalbarczyk.judgmentapp.objectrep.Item;
import java.io.File;
import java.io.IOException;

// FOR TEST PURPOSE ONLY // FOR TEST PURPOSE ONLY // FOR TEST PURPOSE ONLY

public class TrainingArea {

    public static void main(String[] args) {

        try {

            RawDataKeeper dK = new RawDataKeeper(Converter.convertAll(new File("C:\\Users\\Michał Barczyk\\Desktop\\json\\json")));



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
