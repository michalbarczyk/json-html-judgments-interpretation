package com.michalbarczyk.judgmentapp.objectrep;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalbarczyk.judgmentapp.objectrep.JudgmentsPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<JudgmentsPack> convertAll(File folder) throws IOException {

        List<JudgmentsPack> judgmentsPacks = new ArrayList<>();

        for (File file : folder.listFiles())
            judgmentsPacks.add(convert(file));

        return judgmentsPacks;
    }

    private static JudgmentsPack convert(File file) throws IOException, IllegalArgumentException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (isJSON(file))
            return objectMapper.readValue(file, JudgmentsPack.class);

        else throw new IllegalArgumentException(file.getName() + " is not JSON file");
    }

        List<JudgmentsPack> judgmentsPacks = new ArrayList<>();

    private static boolean isJSON(File file) {

        String filename = file.getName();
        return filename.endsWith(".json");
    }
}
