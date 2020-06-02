package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class MyLogger {
    private static MyLogger instance = null;
    private static File file;
    private static FileOutputStream outputStream;
    private static final String filePath = "log.csv";

    private MyLogger() { }

    public static MyLogger getInstance() throws IOException {
        if (instance == null) {
            instance = new MyLogger();
        }
        return instance;
    }

    public static void write(String method) {
        try {
            if (file == null) {
                file = new File(filePath);
            }
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);

            String output = method + ", " + LocalDateTime.now() + ", " + Thread.currentThread().getName() + "\n";
            byte[] contentInBytes = output.getBytes();
            outputStream.write(contentInBytes);

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
