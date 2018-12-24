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
    BufferedWriter writer;

    public ConsoleInterpreter(RawDataKeeper rawDataKeeper, File file) {

        this.rawDataKeeper = rawDataKeeper;
        this.iConsoleStats = new ArrayList<>();
        this.iConsoleInfos = new ArrayList<>();
        this.help = null;
        this.commandFile = file;
        this.writer = null;

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
        String response;
        String[] parsedLine;
        boolean commandProcessed;

        try {

            if (commandFile != null) {

                writer = new BufferedWriter(new FileWriter(commandFile));
            }


            while ((line = readLine(reader, "")) != null) {

                commandProcessed = false;
                parsedLine = Utils.parseLine(line);

                StringBuilder currCommands = new StringBuilder();
                currCommands.append(line);
                currCommands.append(" => ");

                for (IConsoleStats iCS : iConsoleStats) {

                    if (parsedLine[0].equals(iCS.getName())) {

                        response = iCS.getResult();
                        System.out.print(response);
                        currCommands.append(response);
                        fileWriter(currCommands.toString());
                        commandProcessed = true;
                        break;
                    }
                }

                if (commandProcessed)
                    continue;

                for (IConsoleInfo iCI : iConsoleInfos) {

                    if (parsedLine[0].equals(iCI.getName())) {

                        response = iCI.getResult(parsedLine);
                        System.out.print(response);
                        currCommands.append(response);
                        fileWriter(currCommands.toString());
                        commandProcessed = true;
                        break;
                    }
                }

                if (commandProcessed)
                    continue;

                if (parsedLine[0].equals("help")) {

                    response = getHelp();
                    System.out.print(response);
                    currCommands.append(response);
                    fileWriter(currCommands.toString());
                    continue;
                }

                if (parsedLine[0].equals("exit")) {
                    fileWriter(currCommands.toString());
                    break;
                }
                else {
                    response = handleSpellingMistake(parsedLine[0]);
                    System.out.print(response);
                    currCommands.append(response);
                    fileWriter(currCommands.toString());
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

    private String handleSpellingMistake(String misCommand) {

        return "Command \"" + misCommand + "\" is not recognized, type help";
    }

    private void fileWriter(String text) throws IOException {

        if (this.commandFile != null) {

            writer.write(text.toString());
            writer.newLine();
            writer.newLine();
            writer.newLine();
        }
    }
}
