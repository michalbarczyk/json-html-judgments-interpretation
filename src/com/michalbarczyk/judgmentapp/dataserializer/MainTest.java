package com.michalbarczyk.judgmentapp.dataserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

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

        for (Judge j : judgmentsPack.getItems().get(99).getJudges()) {
            System.out.println(j.getName());
        }



    }

    private static File jsonFile() {
        return new File("C:\\Users\\Michał Barczyk\\Desktop\\json\\json\\judgments-348.json");
    }
}