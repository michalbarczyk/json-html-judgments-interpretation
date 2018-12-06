package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.dataanalyzer.*;
import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ConsoleInterpreter {

    private String[] commandsList; //TODO
    private RawDataKeeper rawDataKeeper;
    private JudgeStats judgeStats;
    private CourtTypeStats courtTypeStats;
    private JudgeItemRatioStats judgeItemRatioStats;
    private RegulationStats regulationStats;


    public ConsoleInterpreter(RawDataKeeper rawDataKeeper) {

        commandsList = new String[] { "help", "exit" }; //TODO
        this.rawDataKeeper = rawDataKeeper;
        this.judgeStats = null;
        this.courtTypeStats = null;
        this.judgeItemRatioStats = null;
        this.regulationStats = null;
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

                    break;
                case Consts.JUSTIFICATION:
                    //
                    break;
                case Consts.STATS_JUDGES_PER_JUDGMENT:
                    if (judgeItemRatioStats == null)
                        judgeItemRatioStats = new JudgeItemRatioStats(rawDataKeeper);
                    judgeItemRatioStats.print();
                    break;
                case Consts.JUDGMENTS_NO_PER_JUDGE:
                    if (judgeStats == null)
                        judgeStats = new JudgeStats(rawDataKeeper);
                    //judgeStats.printItemsQtyByJudgeName(parsedLine);
                    break;
                case Consts.STATS_NO_PER_COURT_TYPE:
                    if (courtTypeStats == null)
                        courtTypeStats = new CourtTypeStats(rawDataKeeper);
                    courtTypeStats.print();
                    break;
                case Consts.TOP_10_JUDGES:
                    //
                    break;
                case Consts.TOP_10_REGULATIONS:
                    if (regulationStats == null)
                        regulationStats = new RegulationStats(rawDataKeeper);
                    regulationStats.print();
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
        System.out.println("Welcome to Judgment App");

    }

    private void printHelp() {
        System.out.println("help		- Show help");
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
    }

    private String[] parseLine(String line) {

        String delims = "[ ]+";
        String[] tokens = line.split(delims);

        return tokens;
    }

    private void exitMessage() {

        System.out.println("Goodbye");
    }

    private void handleInvalidCommand(String invalidCommand) {

        System.out.println(invalidCommand + " is invalid, type help");
    }

}
