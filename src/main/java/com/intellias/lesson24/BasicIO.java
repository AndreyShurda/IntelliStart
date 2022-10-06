package com.intellias.lesson24;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class BasicIO {
    public static void main(String[] args) throws URISyntaxException, IOException {

        File fileFromResource = new BasicIO().getFileFromResource("xanadu.txt");

        scanAndPrintFile(fileFromResource);
        System.out.println();
        System.out.println("FileInputStream");
        byteCopier(fileFromResource, "test.txt");
        System.out.println();
        System.out.println("useBufferedReader");
        buffereCopier(fileFromResource, "test.txt");
    }

    private static void buffereCopier(File file, String outputFile) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file));
             PrintWriter outputStream = new PrintWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line);
                System.out.println(line);
            }
        }
    }

    private static void byteCopier(File fileFromResource, String outputFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(fileFromResource);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
                System.out.println(c);
            }
        }
    }

    private static void scanAndPrintFile(File fileFromResource) throws FileNotFoundException {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(fileFromResource)))) {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}
