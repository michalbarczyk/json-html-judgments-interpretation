package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.analyzer.RawDataKeeper;

import java.io.File;
import java.io.IOException;

public class Init {

    public static void main(String[] args) {

        try {

            if (args == null || args.length == 0 || args.length > 2)
                throw new IllegalArgumentException("only 1 or 2 args are accepted");

            Converter converter = new Converter();
            RawDataKeeper rawDataKeeper = new RawDataKeeper(converter.convertAll(new File(args[0])));
            ConsoleInterpreter consoleInterpreter;

            if (args.length == 1)
                consoleInterpreter = new ConsoleInterpreter(rawDataKeeper, null);

            else
                consoleInterpreter = new ConsoleInterpreter(rawDataKeeper, new File(args[1]));

            consoleInterpreter.run();

        } catch (IOException e) {
            e.getMessage();
        }
    }

}
