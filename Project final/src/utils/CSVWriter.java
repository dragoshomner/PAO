package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private static CSVWriter instance = null;

    private CSVWriter() { }

    public static CSVWriter getInstance() {
        if (instance == null) {
            instance = new CSVWriter();
        }
        return instance;
    }

    public void write(String filePath, List<String> output) {
        File file = new File(filePath);

        try (FileOutputStream fop = new FileOutputStream(file)) {

            if (!file.exists()) {
                file.createNewFile();
            }

            for (String content : output) {
                byte[] contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }

            fop.flush();
            fop.close();

            System.out.println("Wrote in file!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
