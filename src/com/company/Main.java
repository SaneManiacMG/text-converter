package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Choose Format:\n1: Single Quotes\n2: DoubleQuotes\nAny Char: No Quotes:\n==> ");
        Scanner input = new Scanner(System.in);
        int selection = 0;
        

        try {
            selection = input.nextInt();
        } catch (Exception e) {
            selection = 0;
        }

        addQuotations(selection);
    }

    public static void addQuotations(int quotationType) {
        
        String quoteType = "";

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
