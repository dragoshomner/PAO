package utils;

import models.Marketplace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    private static CSVReader instance = null;
    private static final String DELIMITER = ",";

    private CSVReader() { }

    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

    public List<List<String>> read(String filePath) {
        BufferedReader br = null;
        String line = "";
        List<List<String>> result = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                List<String> input = Arrays.asList(line.split("\\s*" + DELIMITER + "\\s*"));
                result.add(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

}
