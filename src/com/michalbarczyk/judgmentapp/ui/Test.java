package com.michalbarczyk.judgmentapp.ui;

import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ConsoleInterpreter cI = new ConsoleInterpreter();
        //cI.init();
        cI.run();
    }

}
