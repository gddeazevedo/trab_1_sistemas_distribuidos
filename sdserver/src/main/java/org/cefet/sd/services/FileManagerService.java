package org.cefet.sd.services;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class FileManagerService {
    private static String fileName = null;

    public FileManagerService() {}

    public FileManagerService(String file) {
        fileName = file;
    }

    public boolean createFile() {
        if (fileName == null) {
            System.out.println("File name is empty");
            return false;
        }

        File file = new File(fileName);

        boolean created = false;

        if (!file.exists()) {
            try {
                created = file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }

        return created;
    }

    public void write(String message) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getNumberOfLines() throws Exception {
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);
        int lineCounter = 0;
        while (bufferedReader.readLine() != null) {
            lineCounter++;
        }
        bufferedReader.close();
        return lineCounter;
    }
}
