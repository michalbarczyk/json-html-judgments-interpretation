package com.michalbarczyk.judgmentapp;

import com.michalbarczyk.judgmentapp.analyzer.RawDataKeeper;
//import com.michalbarczyk.judgmentapp.data.Converter;
import com.michalbarczyk.judgmentapp.data.Converter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.util.*;



// FOR TEST PURPOSE ONLY // FOR TEST PURPOSE ONLY // FOR TEST PURPOSE ONLY

public class TrainingArea {

    public static void main(String[] args) {

        //try {

        //RawDataKeeper dK = new RawDataKeeper(Converter.convertAll(new File("C:\\Users\\Michał Barczyk\\Desktop\\json\\json")));

            /*File file = new File("C:\\Users\\Michał Barczyk\\Desktop\\html\\01\\21\\AADA799170.html");
            //File file = new File("C:\\Users\\Michał Barczyk\\Desktop\\html\\01\\21\\DDF01C4BCD.html");
            //File file = new File("C:\\Users\\Michał Barczyk\\Desktop\\html\\01\\08\\6BBB9A7A42.html");

            Document doc = Jsoup.parse(file, "UTF-8");

            Element table = doc.select("table").get(3);

            Element row = table.select("tr").get(0);

            Element tdx = row.select("td").get(0);
            Element tdy = tdx.nextElementSibling().select("td").get(1);

            System.out.print(tdx.text() + " : " + tdy.text()+ "\n");

            Elements rows = row.siblingElements();

            for (Element e: rows) {

                Element td0 = e.select("td").get(0);
                if (td0.child(0).text().equals("Uzasadnienie")) {

                    System.out.print(td0.child(0).text() + " : " + td0.child(1).text());
                    break;
                }


                System.out.print(td0.text());

                Elements tds = td0.siblingElements();

                for (Element r : tds) {

                    System.out.print(" : " + Converter.extractJudgesWithRoles(r.toString()));


                }

                System.out.print("\n");

            }





            /*Element row2 = rows.get(0); //data
            row2 = row2.select("td").get(2);
            row2 = row2.select("table").get(0);
            row2 = row2.select("tr").get(0);
            row2 = row2.select("td").get(0);
            System.out.println(row2);

            row2 = rows.get(3); //sąd
            row2 = row2.select("td").get(2);
            System.out.println(row2);*/

          /*
        } catch (IOException e) {
            e.printStackTrace();
        } */
        System.out.print("Sędziowie");
    }

}
