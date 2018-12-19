package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.Consts;
import com.michalbarczyk.judgmentapp.Utils;
import com.michalbarczyk.judgmentapp.dataanalyzer.*;
import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConsoleInterpreter {

    private RawDataKeeper rawDataKeeper;
    private JudgeStats judgeStats;
    //DONE private CourtTypeStats courtTypeStats;
    //DONE private JudgeItemRatioStats judgeItemRatioStats;
    private RegulationStats regulationStats;
    private BestJudgesStats bestJudgesStats;
    private MonthStats monthStats;

    private List<IConsoleElement> iConsoleElements;


    public ConsoleInterpreter(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        iConsoleElements = new ArrayList<>();

        iConsoleElements.add(new CourtTypeStats(rawDataKeeper));
        iConsoleElements.add(new JudgeItemRatioStats(rawDataKeeper));


        this.judgeStats = null;
        this.regulationStats = null;
        this.bestJudgesStats = null;
        this.monthStats = null;
    }

    public void run() {

        AnsiConsole.systemInstall(); // needed to support ansi on Windows cmd
        printWelcomeMessage();
        LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
        List<Completer> completers = new LinkedList<>();
        //completers.add(new StringsCompleter(commandsList));
        readerBuilder.completer(new ArgumentCompleter(completers));

        LineReader reader = readerBuilder.build();

        String line;
        String[] parsedLine;
        PrintWriter out = new PrintWriter(System.out);


        while ((line = readLine(reader, "")) != null) {

            parsedLine = Utils.parseLine(line);

            for (IConsoleElement iCE : iConsoleElements) {

                if (parsedLine[0].equals(iCE.getName())) {

                    System.out.print(iCE.getResult());
                    break;
                }


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
