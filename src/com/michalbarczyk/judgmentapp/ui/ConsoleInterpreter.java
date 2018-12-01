package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.dataanalyzer.Converter;
import com.michalbarczyk.judgmentapp.dataanalyzer.Judge;
import com.michalbarczyk.judgmentapp.dataanalyzer.JudgmentsPack;
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

    public ConsoleInterpreter(List<JudgmentsPack> judgmentsPacks) {

        commandsList = new String[] { "help", "action1", "action2", "exit" };
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
        PrintWriter out = new PrintWriter(System.out);

        while ((line = readLine(reader, "")) != null) {

            if ("help".equals(line)) {
                printHelp();
            } else if ("action1".equals(line)) {

                for (Judge j : judgmentsPacks.get(5).getItems().get(99).getJudges())
                    System.out.println(j.getName());

            } else if ("action2".equals(line)) {
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
        System.out.println("action1		- Execute action1");
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
}
