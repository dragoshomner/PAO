package utils;

import models.Marketplace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    public List<Marketplace> readMarketplace(String filePath) {
        BufferedReader br = null;
        String line = "";
        List<Marketplace> marketplaces = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] input = line.split(DELIMITER);
                Marketplace marketplace = new Marketplace(input[0]);
                marketplaces.add(marketplace);
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

        return marketplaces;
    }

}
