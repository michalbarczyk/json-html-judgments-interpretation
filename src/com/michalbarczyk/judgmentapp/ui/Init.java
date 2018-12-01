package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.dataanalyzer.Converter;

import java.io.File;
import java.io.IOException;

public class Init {

    public static void main(String[] args) {

        try {
            ConsoleInterpreter cI = new ConsoleInterpreter(Converter.convertAll(new File(args[0])));
            cI.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
