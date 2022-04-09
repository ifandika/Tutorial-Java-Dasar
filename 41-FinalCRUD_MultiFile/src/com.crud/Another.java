package com.crud;

import java.time.Year;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Another {
    
    public static boolean optionYesOrNo(String message) {
        
        Scanner systemInput = new Scanner(System.in);
        System.out.printf("\n%s (y/n): ", message);
        String inputUser = systemInput.next();
        
        while(!inputUser.equalsIgnoreCase("y") && !inputUser.equalsIgnoreCase("n")) {
            System.err.println("Your input not valid");
            System.out.printf("\n%s (y/n): ", message);
            inputUser = systemInput.next();
        }
        return inputUser.equalsIgnoreCase("y");
    }
    
    public static void clearScreen() {
        
        try {
            // untuk clear terminal/cmd di windows
            if(System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            // untuk linux/unix macOS
            else {
                System.out.print("\033\143");
            }
        }
        catch(Exception message) {
            System.out.println("Failed to clear terminal");
        }
    }
    
    protected static boolean checkBookInDbase(String[] dataKeyword, boolean displayBookResult) throws IOException {
        
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        
        String dataBook = bufferInput.readLine();
        int noBook = 0;
        boolean keywordResult = false;
        
        if(displayBookResult) {
            System.out.println("| NO | TAHUN |    GENRE    |   PENULIS  |     JUDUL");
            System.out.println("--------------------------------------------------------------");
        }
        
        while(dataBook != null) {
            keywordResult = true;
            for(String data : dataKeyword) {
                keywordResult = keywordResult && dataBook.toLowerCase().contains(data.toLowerCase());
            }
            if(keywordResult) {
                if(displayBookResult) {
                    StringTokenizer strToken = new StringTokenizer(dataBook, ",");
                    noBook++;
                    System.out.printf("|%-4d", noBook);
                    strToken.nextToken();
                    System.out.printf("|%-7s", strToken.nextToken());
                    System.out.printf("|%-13s", strToken.nextToken());
                    System.out.printf("|%-12s", strToken.nextToken());
                    System.out.printf("|%s\n", strToken.nextToken());
                }
                else {
                    break;
                }
            }
            // Refresh
            dataBook = bufferInput.readLine();
        }
        if(displayBookResult) {
            System.out.println("--------------------------------------------------------------");
        }
        return keywordResult;
    }
    
    // default
    static int checkEntry(String penulis, String dataYear) throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        String dataBook = bufferInput.readLine();
        String primaryKey;
        int noEntryBook = 0;
        Scanner scanner;
        
        while(dataBook != null) {
            scanner = new Scanner(dataBook);
            scanner.useDelimiter(",");
            primaryKey = scanner.next();
            scanner = new Scanner(primaryKey);
            scanner.useDelimiter("_"); 
            penulis = penulis.replaceAll("\\s+", "");
            if(penulis.equalsIgnoreCase(scanner.next()) && dataYear.equalsIgnoreCase(scanner.next())) {
                noEntryBook = scanner.nextInt();
            }
            dataBook = bufferInput.readLine();
        }
        return noEntryBook;
    }
    
    protected static String checkYear() throws IOException {
        
        boolean yearValid = false;
        Scanner scanner = new Scanner(System.in);
        String inputYear = scanner.nextLine();
        while(!yearValid) {
            try {
                Year.parse(inputYear);
                yearValid = true;
            }
            catch(Exception e) {
                System.err.println("Format tahun tidak valid");
                System.out.print("Masukan Tahun terbit : ");
                inputYear = scanner.nextLine();
                yearValid = false;
            }
        }
        return inputYear;
    }
}