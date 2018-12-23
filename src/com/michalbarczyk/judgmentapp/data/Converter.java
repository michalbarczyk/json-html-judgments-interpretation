package com.michalbarczyk.judgmentapp.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.external.jsoup.Jsoup;

import com.vaadin.external.jsoup.Jsoup;
import com.vaadin.external.jsoup.nodes.Document;
import com.vaadin.external.jsoup.nodes.Element;
import com.vaadin.external.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Converter {

    public static Map<String, Item> convertAll(File folder) throws IOException {

        List<JudgmentsPack> judgmentsPacks = new ArrayList<>();
        Map<String, Item> items = new HashMap<>();

        for (File file : folder.listFiles())
            judgmentsPacks.add(convertJSON(file));

        for (JudgmentsPack jP : judgmentsPacks) {

            for (Item item : jP.getItems()) {

                items.put(item.getCourtCases().get(0).getCaseNumber(), item);
            }
        }

        return items;
    }

    private static JudgmentsPack convertJSON(File file) throws IOException, IllegalArgumentException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (isJSON(file))
            return objectMapper.readValue(file, JudgmentsPack.class);



        else throw new IllegalArgumentException(file.getName() + " is not JSON file");
    }

    private static Item convertHTML(File file) throws IOException, IllegalArgumentException {

        Item item = new Item();

        Document doc = Jsoup.parse(file, "UTF-8");
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
                break;
            }

            if (td0.text().equals("Sędziowie")) {

                td1 = td0.nextElementSibling();


            }



            if (td0.child(0).text().equals("Uzasadnienie")) {

                System.out.print(td0.child(0).text() + " : " + td0.child(1).text());
                break;
            }




        }
    }

    private static boolean isJSON(File file) {

        String filename = file.getName();
        return filename.endsWith(".json");
    }

    private static boolean isHTML(File file) {

        String filename = file.getName();
        return filename.endsWith(".html");
    }

    private static String getCourtType(String courtType) {

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

    private static List<Judge> extractJudges
}
