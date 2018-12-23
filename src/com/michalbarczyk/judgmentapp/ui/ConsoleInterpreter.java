package com.michalbarczyk.judgmentapp.ui;

import com.michalbarczyk.judgmentapp.Utils;
import com.michalbarczyk.judgmentapp.analyzer.*;
import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInterpreter {

    private RawDataKeeper rawDataKeeper;
    private List<IConsoleStats> iConsoleStats;
    private List<IConsoleInfo> iConsoleInfos;
    private String help;
    private File commandFile;

    public ConsoleInterpreter(RawDataKeeper rawDataKeeper, File file) {

        this.rawDataKeeper = rawDataKeeper;
        this.iConsoleStats = new ArrayList<>();
        this.iConsoleInfos = new ArrayList<>();
        this.help = null;
        this.commandFile = file;

        iConsoleInfos.add(new Rubrum(rawDataKeeper));
        iConsoleInfos.add(new ContentInfo(rawDataKeeper));
        JudgeInfo judgeInfo = new JudgeInfo(rawDataKeeper);
        iConsoleInfos.add(judgeInfo);

        iConsoleStats.add(new CourtTypeStats(rawDataKeeper));
        iConsoleStats.add(new JudgeItemRatioStats(rawDataKeeper));
        iConsoleStats.add(new MonthStats(rawDataKeeper));
        iConsoleStats.add(new RegulationStats(rawDataKeeper));
        iConsoleStats.add(new BestJudgesStats(rawDataKeeper, judgeInfo));

    }

    public void run() throws IOException {

        AnsiConsole.systemInstall(); // needed to support ansi on Windows cmd
        printWelcomeMessage();
        LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
        LineReader reader = readerBuilder.build();
        String line;
        String[] parsedLine;
        BufferedWriter writer = null;

        try {

            if (commandFile != null) {

                writer = new BufferedWriter(new FileWriter(commandFile));
            }


            while ((line = readLine(reader, "")) != null) {

                parsedLine = Utils.parseLine(line);
                StringBuilder currCommands = new StringBuilder();

                currCommands.append(line);
                currCommands.append(" => ");

                if (parsedLine[0].equals("help")) {

                    System.out.print(getHelp());
                    currCommands.append(getHelp());
                }

                if (parsedLine[0].equals("exit"))
                    break;

                for (IConsoleStats iCS : iConsoleStats) {

                    if (parsedLine[0].equals(iCS.getName())) {

                        System.out.print(iCS.getResult());
                        currCommands.append(iCS.getResult());
                        break;
                    }
                }

                for (IConsoleInfo iCI : iConsoleInfos) {

                    if (parsedLine[0].equals(iCI.getName())) {

                        System.out.print(iCI.getResult(parsedLine));
                        currCommands.append(iCI.getResult(parsedLine));
                        break;
                    }
                }

                if (this.commandFile != null) {
                    writer.write(currCommands.toString());
                    writer.newLine();
                    writer.newLine();
                    writer.newLine();
                }

            }

        } catch (IOException e) {
            e.getMessage();
        } finally {
            if (commandFile != null)
                writer.close();

        }

        AnsiConsole.systemUninstall();
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to Judgment App");
    }

    private String getHelp() {

        if (help == null) {

            StringBuilder result = new StringBuilder();

            for (IConsoleInfo iCI : iConsoleInfos) {
                result.append(iCI.getName());
                result.append(" -> ");
                result.append(iCI.getHelp());
                result.append("\n");
            }

            for (IConsoleStats iCS : iConsoleStats) {
                result.append(iCS.getName());
                result.append(" -> ");
                result.append(iCS.getHelp());
                result.append("\n");
            }

            this.help = result.toString();
        }

        return this.help;
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
