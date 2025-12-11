package com.login.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static String[][] readCSV(String filePath) {

        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(","));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows.toArray(new String[0][]);
    }
}
