package com.intellias.lesson9;

import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Log
public class Exceptions {
    public static void main(String[] args) {
        Printer.print(45.123f);
        PrinterNumbers printerNumbers = new PrinterNumbers();
        System.out.println(null instanceof Object);
        printerNumbers.printNumber("12.0");

        try {
            Printer.print(45.123D);
            readLineFromFile("file.txt");
//            Printer.print(null);
//            Printer.print("as");
        } catch (PrinterException e) {
            System.out.println("We have not number: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("We have null value: " + e.getMessage());
            log.info("We have null value:" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally execute");
        }
        System.out.println("end");
    }

    static String readLineFromFile(String path) throws IOException {
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
                return bufferedReader.readLine();
        }
    }
}
