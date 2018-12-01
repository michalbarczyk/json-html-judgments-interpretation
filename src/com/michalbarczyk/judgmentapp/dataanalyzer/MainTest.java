package com.michalbarczyk.judgmentapp.dataanalyzer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class MainTest {

    public static void main(String[] args)    {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JudgmentsPack judgmentsPack = null;

        try {
            judgmentsPack = objectMapper.readValue(jsonFile(), JudgmentsPack.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(DataKeeper.generateKey(judgmentsPack.getItems().get(0)));



    }

    private static File jsonFile() {
        return new File("C:\\Users\\Michał Barczyk\\Desktop\\json\\json\\judgments-348.json");
    }
}
