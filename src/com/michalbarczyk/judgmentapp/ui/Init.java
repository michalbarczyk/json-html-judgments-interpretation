package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.analyzer.RawDataKeeper;

import java.io.File;
import java.io.IOException;

public class Init {

    public static void main(String[] args) {

        try {

            RawDataKeeper dK = new RawDataKeeper(Converter.convertAll(new File(args[0])));
            ConsoleInterpreter cI = new ConsoleInterpreter(dK);
            cI.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
