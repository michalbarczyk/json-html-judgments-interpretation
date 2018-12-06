package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.Consts;
import com.michalbarczyk.judgmentapp.Utils;
import com.michalbarczyk.judgmentapp.dataanalyzer.*;
import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ConsoleInterpreter {

    private String[] commandsList;
    private RawDataKeeper rawDataKeeper;
    private JudgeStats judgeStats;
    private CourtTypeStats courtTypeStats;
    private JudgeItemRatioStats judgeItemRatioStats;
    private RegulationStats regulationStats;
    private BestJudgesStats bestJudgesStats;
    private MonthStats monthStats;


    public ConsoleInterpreter(RawDataKeeper rawDataKeeper) {

        commandsList = new String[]{Consts.EXIT,
                                    Consts.HELP,
                                    Consts.JUDGMENTS_NO_PER_JUDGE,
                                    Consts.JUSTIFICATION,
                                    Consts.STATS_JUDGES_PER_JUDGMENT,
                                    Consts.STATS_NO_PER_COURT_TYPE,
                                    Consts.STATS_NO_PER_YYYY_MM,
                                    Consts.TOP_10_JUDGES,
                                    Consts.TOP_10_REGULATIONS,
                                    Consts.RUBRUM
        };
        this.rawDataKeeper = rawDataKeeper;
        this.judgeStats = null;
        this.courtTypeStats = null;
        this.judgeItemRatioStats = null;
        this.regulationStats = null;
        this.bestJudgesStats = null;
        this.monthStats = null;
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

            parsedLine = Utils.parseLine(line);

            switch (parsedLine[0]) {

                case Consts.RUBRUM:
                    //TODO
                    break;
                case Consts.JUSTIFICATION:
                    //TODO
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
                    if (bestJudgesStats == null)
                        bestJudgesStats = new BestJudgesStats(rawDataKeeper);
                    bestJudgesStats.print();
                    break;
                case Consts.TOP_10_REGULATIONS:
                    if (regulationStats == null)
                        regulationStats = new RegulationStats(rawDataKeeper);
                    regulationStats.print();
                    break;
                case Consts.STATS_NO_PER_YYYY_MM:
                    if (monthStats == null)
                        monthStats = new MonthStats(rawDataKeeper);
                    monthStats.print();
                    break;
                case Consts.HELP:
                    printHelp();
                    break;
                case Consts.EXIT:
                    printExitMessage();
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

        System.out.println(Consts.EXIT + " - exit applicaton");
        System.out.println(Consts.HELP + " - print help");
        System.out.println(Consts.JUDGMENTS_NO_PER_JUDGE + " - prints judgments quantity per judge");
        System.out.println(Consts.JUSTIFICATION + " - prints justification by signature");
        System.out.println(Consts.STATS_JUDGES_PER_JUDGMENT + " - prints amount of judges per judgments");
        System.out.println(Consts.STATS_NO_PER_COURT_TYPE + " - prints amount of judgments per court type");
        System.out.println(Consts.STATS_NO_PER_YYYY_MM + " - prints amount of judgments per month");
        System.out.println(Consts.TOP_10_JUDGES + " - prints top 10 most active judges");
        System.out.println(Consts.TOP_10_REGULATIONS + " - prints top 10 most referenced regulations");
        System.out.println(Consts.RUBRUM + " - prints rubrum(s) by signature(s)");
    }

    private void printExitMessage() {

        System.out.println("Goodbye");
    }

    private void handleInvalidCommand(String invalidCommand) {

        System.out.println(invalidCommand + " is invalid, type help");
    }

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



}
