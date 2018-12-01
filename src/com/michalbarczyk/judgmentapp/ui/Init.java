package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.dataanalyzer.Converter;
import com.michalbarczyk.judgmentapp.dataanalyzer.DataKeeper;

import java.io.File;
import java.io.IOException;

public class Init {

    public static void main(String[] args) {

        try {

            DataKeeper dK = new DataKeeper(Converter.convertAll(new File(args[0])));
            ConsoleInterpreter cI = new ConsoleInterpreter(dK);
            cI.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
