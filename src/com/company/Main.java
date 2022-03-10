package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Choose Format:\n1: Single Quotations\n2: DoubleQuotations\n==> ");
        Scanner input = new Scanner(System.in);
        int selection = 0;
        selection = input.nextInt();

        addQuotations(selection);
    }

    public static void addQuotations(int quotationType) {
        String quoteType = null;
        if (quotationType == 1) {
            quoteType = "\'";
        } else if (quotationType == 2) {
            quoteType = "\"";
        }
        int i = 0;
        try {
            File myFile = new File ("file.txt");
            System.out.println("\nReading Text File...\n");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String lineOutput = quoteType + data + quoteType;
                i++;
                if (myReader.hasNextLine()) {
                    lineOutput = lineOutput + ",";
                }
                System.out.println(lineOutput);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error has occurred: ");
            e.printStackTrace();
        }

        System.out.println("Lines: " + i);
    }
}
