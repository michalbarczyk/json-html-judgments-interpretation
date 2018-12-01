package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.dataanalyzer.DataKeeper;
import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ConsoleInterpreter {

    private String[] commandsList;
    private DataKeeper dataKeeper;

    public ConsoleInterpreter(DataKeeper dataKeeper) {

        commandsList = new String[] { "help", "action1", "action2", "exit" };
        this.dataKeeper = dataKeeper;
    }

    public void run() {

        AnsiConsole.systemInstall(); // needed to support ansi on Windows cmd
        printWelcomeMessage();
        LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
        List<Completer> completers = new LinkedList<>();
        completers.add(new StringsCompleter(commandsList));
        readerBuilder.completer(new ArgumentCompleter(completers));

        LineReader reader = readerBuilder.build();

        String line;
        String[] parsedLine;
        PrintWriter out = new PrintWriter(System.out);


        while ((line = readLine(reader, "")) != null) {

            parsedLine = parseLine(line);

            if ("help".equals(parsedLine[0])) {

                printHelp();

            } else if ("rubrum".equals(parsedLine[0])) {


            } else if ("".equals(line)) {
                AttributedStringBuilder a = new AttributedStringBuilder()
                        .append("You have selected ")
                        .append("action2", AttributedStyle.BOLD.foreground(AttributedStyle.RED))
                        .append("!");

                System.out.println(a.toAnsi());
            } else if ("exit".equals(line)) {
                System.out.println("Exiting application");
                return;
            } else {
                System.out
                        .println("Invalid command, For assistance press TAB or type \"help\" then hit ENTER.");
            }
        }

        AnsiConsole.systemUninstall();
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to jLine Sample App. For assistance press TAB or type \"help\" then hit ENTER.");

    }

    private void printHelp() {
        System.out.println("help		- Show help");
        System.out.println("rubrum 		- Execute action1");
        System.out.println("action2		- Execute action2");
        System.out.println("exit        - Exit the app");

    }

    private String readLine(LineReader reader, String promtMessage) {
        try {
            String line = reader.readLine(promtMessage + "\nshell> ");
            return line.trim();
        }
        catch (UserInterruptException e) {
            // e.g. ^C
            return null;
        }
        catch (EndOfFileException e) {
            // e.g. ^D
            return null;
        }
    }

    private String[] parseLine(String line) {

        String delims = "[ ]+";
        String[] tokens = line.split(delims);

        return tokens;
    }
}
