package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.dataanalyzer.Consts;
import com.michalbarczyk.judgmentapp.dataanalyzer.DataKeeper;
import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConsoleInterpreter {

    private String[] commandsList; //TODO
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

            switch (parsedLine[0]) {

                case Consts.RUBRUM:
                    //
                    break;
                case Consts.JUSTIFICATION:
                    //
                    break;
                case Consts.STATS_JUDGES_PER_JUDGMENT:
                    printStatsJudgesPerJudgment();
                    break;
                case Consts.JUDGMENTS_NO_PER_JUDGE:
                    //
                    break;
                case Consts.STATS_NO_PER_COURT_TYPE:
                    dataKeeper.getCourtTypeStats().printStats();
                    break;
                case Consts.TOP_10_JUDGES:
                    //judgesStats.printAll();
                    break;
                case Consts.TOP_10_JUDGMENTS:
                    //
                    break;
                case Consts.STATS_NO_PER_MM_YYYY:
                    //
                    break;
                case Consts.HELP:
                    //
                    break;
                case Consts.EXIT:
                    exitMessage();
                    return;

                    default:
                        handleInvalidCommand(parsedLine[0]);

            }
        }

        AnsiConsole.systemUninstall();
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to jLine Sample App. For assistance press TAB or type \"help\" then hit ENTER.");

    } //TODO

    private void printHelp() {
        System.out.println("help		- Show help");
        System.out.println("rubrum 		- Execute action1");
        System.out.println("action2		- Execute action2");
        System.out.println("exit        - Exit the app");

    } //TODO

    private String readLine(LineReader reader, String promtMessage) {
        try {
            String line = reader.readLine(promtMessage + "\n>>> ");
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

    private void printRubrums(String[] signatures) {} //TODO

    private void printStatsJudgesPerJudgment() {

        for (Map.Entry<Integer,Integer> stat : dataKeeper.getStatsJudgesPerJudgment().entrySet()) {

            System.out.println("There were " + stat.getKey() + " judge(s) in " + stat.getValue() + " judgments");
        }

    }

    private void exitMessage() {

        System.out.println("Goodbye");
    }

    private void handleInvalidCommand(String invalidCommand) {

        System.out.println(invalidCommand + " is invalid, type help");
    }

}
