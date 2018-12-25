package com.michalbarczyk.judgmentapp.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalbarczyk.judgmentapp.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Converter {

    public Map<String, Item> convertAll(File folder) throws IOException {

        List<JudgmentsPack> judgmentsPacks = new ArrayList<>();
        Map<String, Item> items = new HashMap<>();

        List<File> files = (List<File>) FileUtils.listFiles(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        for (File file : files) {

            if (isJSON(file)) {
                judgmentsPacks.add(convertJSON(file));
            }

            else if (isHTML(file)) {

                Item item = convertHTML(file);
                items.put(item.getCourtCases().get(0).getCaseNumber(), item);
            }

            else throw new IllegalArgumentException(file.getName() + " is not JSON/HTML file");
        }

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                items.put(item.getCourtCases().get(0).getCaseNumber(), item);
            }
        }

        return items;
    }

    private JudgmentsPack convertJSON(File file) throws IOException, IllegalArgumentException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(file, JudgmentsPack.class);
    }

    private Item convertHTML(File file) throws IOException, IllegalArgumentException {

        Item item = new Item();

        Document doc = Jsoup.parse(file, "UTF-8");

        Element signature = doc.getElementById("warunek");
        String[] parsedSignature = Utils.parseLineBy(signature.text(), " -");

        List<CourtCase> courtCases = new ArrayList<>();
        courtCases.add(new CourtCase(parsedSignature[0]));
        item.setCourtCases(courtCases);

        Element table = doc.select("table").get(3);

        Element row0 = table.select("tr").get(0);

        Element td0 = row0.select("td").get(0);
        Element td1 = td0.nextElementSibling().select("td").get(1);

        item.setJudgmentDate(td1.text());

        Elements otherRows = row0.siblingElements();

        for (Element e : otherRows) {

            td0 = e.select("td").get(0);

            if (td0.text().equals("Sąd")) {

                td1 = td0.nextElementSibling();
                item.setCourtType(getCourtType(td1.text()));
                continue;
            }

            if (td0.text().equals("Sędziowie")) {

                td1 = td0.nextElementSibling();
                item.setJudges(extractJudgesWithRoles(td1.toString()));
                continue;
            }

            if (td0.text().equals("Powołane przepisy")) {

                td1 = td0.nextElementSibling();
                item.setReferencedRegulations(extractReferencedRegulations(td1.toString()));
                continue;
            }



            if (td0.child(0).text().equals("Uzasadnienie")) {

                item.setTextContent(td0.child(1).text());
            }
        }

        if (item.getJudges() == null) // because of statistic functionalities item.getJudges() must not return null, empty List is ok
            item.setJudges(new ArrayList<Judge>());
        if (item.getReferencedRegulations() == null) // because of statistic functionalities item.getReferencedRegulations() must not return null, empty List is ok
            item.setReferencedRegulations(new ArrayList<ReferencedRegulation>());


        return item;
    }

    private boolean isJSON(File file) {

        String filename = file.getName();
        return filename.endsWith(".json");
    }

    private boolean isHTML(File file) {

        String filename = file.getName();
        return filename.endsWith(".html");
    }

    private  String getCourtType(String courtType) {

        if (courtType.startsWith("Wojewódzki")) {
            return "VOIVODESHIP_ADMINISTRATIVE";
        }

        if (courtType.contains("powszechny")) {
            return "COMMON";
        }

        if (courtType.contains("Trybunał Konstytucyjny")) {
            return "CONSTITUTIONAL_TRIBUNAL";
        }

        if (courtType.contains("Sąd Najwyższy")) {
            return "SUPREME";
        }

        if (courtType.contains("Krajowa Izba Odwoławcza")) {
            return "NATIONAL_APPEAL_CHAMBER";
        }

        if (courtType.contains("Naczelny Sąd Administracyjny")) {
            return "SUPREME_ADMINISTRATIVE";
        }

        return "";
    }

    private List<Judge> extractJudgesWithRoles(String judges) {

        List<Judge> judgesList = new ArrayList<>();

        String[] parsed = Utils.parseLineBy(judges, "<br>");
        List<String> judgesNamesWithRoles = new ArrayList<>();

        for (String name : parsed)
            judgesNamesWithRoles.add(Jsoup.parse(name).text().replaceAll("\\<.*?>",""));

        for (String jNWR : judgesNamesWithRoles) {

            String[] parsedJNWR = Utils.parseLineBy(jNWR, "/");
            parsedJNWR[0] = parsedJNWR[0].trim();

            List<String> specialRoles = new ArrayList<>();

            if (parsedJNWR.length != 1) {

                specialRoles.add(parsedJNWR[1]);
            }

            judgesList.add(new Judge(parsedJNWR[0], specialRoles));
        }

        return judgesList;
    }

    private List<ReferencedRegulation> extractReferencedRegulations(String regs) {

        List<String> RefRegTitlesList = new ArrayList<>();
        List<ReferencedRegulation> RefRefList = new ArrayList<>();

        String[] parsed = Utils.parseLineBy(regs, "<br>");

        for (String name : parsed)
            RefRegTitlesList.add(Jsoup.parse(name).text().replaceAll("\\<.*?>",""));

        for (String title : RefRegTitlesList)
            RefRefList.add(new ReferencedRegulation(title));


        return RefRefList;
    }
}
