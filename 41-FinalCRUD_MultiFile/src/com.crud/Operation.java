package com.crud;

import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.StringTokenizer;

public class Operation {
    
    public static void displayBook() throws IOException {
        
        FileReader fileInput;
        BufferedReader bufferInput;
        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        }
        catch(IOException message) {
            System.out.println(message);
            System.out.println("data buku kosong, harap isi data buku");
            return; // jika error maka akan keluar dari fungsi
        }
        String dataBook = bufferInput.readLine();
        int noBook = 0;

        System.out.println("| NO | TAHUN |    GENRE    |   PENULIS  |     JUDUL");
        System.out.println("--------------------------------------------------------------");
        while(dataBook != null) {
            StringTokenizer strToken = new StringTokenizer(dataBook, ",");
            noBook++;
            
            System.out.printf("|%-4d", noBook);
            strToken.nextToken();
            System.out.printf("|%-7s", strToken.nextToken());
            System.out.printf("|%-13s", strToken.nextToken());
            System.out.printf("|%-12s", strToken.nextToken());
            System.out.printf("|%s\n", strToken.nextToken());
            
            dataBook = bufferInput.readLine();
        }
        System.out.println("--------------------------------------------------------------");
    }
    
    public static void searchBook() throws IOException {
        
        File originDbase;
        try {
            originDbase = new File("database.txt");
        }
        catch(Exception message) {
            System.err.println("data buku kosong, silahkan isi data buku");
            return;
        }
        Scanner systemInput = new Scanner(System.in);
        System.out.print("masukan kata kunci: ");
        String dataKeyword = systemInput.nextLine();
        String[] keywordResult = dataKeyword.split("\\s+");
        
        Another.checkBookInDbase(keywordResult, true);
    }
    
    public static void addBook() throws IOException {
        
        //                                      nameFile     |  mode
        FileWriter fileOutput = new FileWriter("database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
        Scanner systemInput = new Scanner(System.in);
        String penulis, year, genre, judul;
        
        // entry = data keberapa, contoh data ke 1,2,...
        System.out.print("masukan judul buku   : ");
        judul = systemInput.nextLine();
        System.out.print("masukan nama penulis : ");
        penulis = systemInput.nextLine();
        System.out.print("masukan nama genre   : ");
        genre = systemInput.nextLine();
        System.out.print("masukan tahun terbit : ");
        year = Another.checkYear();
        
        String[] dataInput = {
            year+","+genre+","+penulis+","+judul
        };
        boolean result = Another.checkBookInDbase(dataInput, false);

        if(!result) {
            int noEntryBook = Another.checkEntry(penulis, year) + 1;
            String penulisWitNoSpace = penulis.replaceAll("\\s+", "");
            String primaryKey = String.format("%s_%s_%d", penulisWitNoSpace, year, noEntryBook);
            
            System.out.println("\n[ data yang dimasukan ]");
            System.out.printf("primary key  : %s\n", primaryKey);
            System.out.printf("judul buku   : %s\n", judul);
            System.out.printf("nama penulis : %s\n", penulis);
            System.out.printf("genre buku   : %s\n", genre);
            System.out.printf("tahun terbit : %s\n", year);
            
            boolean writeOrNo = Another.optionYesOrNo("save to storage");
            if(writeOrNo) {
                bufferOutput.write(primaryKey+","+year+","+genre+","+penulis+","+judul);
                bufferOutput.newLine();
                bufferOutput.flush();
            }
        }
        else {
            System.out.println("data buku sudah ada, silahkan masukan data buku lain");
            Another.checkBookInDbase(dataInput, true);
        }
        fileOutput.close();
        bufferOutput.close();
    }
    
    public static void deleteBook() throws IOException {
        
        // membaca file asli
        File originDatabase = new File("database.txt");
        FileReader fileInput = new FileReader(originDatabase);
        BufferedReader bufferInput = new BufferedReader(fileInput);
        
        // membuat file database sementara
        File tempDatabase = new File("tempDbase.txt");
        FileWriter fileOutput = new FileWriter(tempDatabase);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
        // tampilkan semua data buku
        System.out.println("List Buku");
        displayBook();
        
        // ambil user input
        Scanner systemInput = new Scanner(System.in);
        System.out.print("Masukan no buku yang akan dihapus: ");
        int deleteNoBook = systemInput.nextInt();
        
        // check buku yang akan dihapus di database
        String dataBook = bufferInput.readLine();
        int noBook = 0;
        
        boolean foundBook = false;
        
        while(dataBook != null) {
            boolean deleteBook = false;
            noBook++;
            
            StringTokenizer strToken = new StringTokenizer(dataBook, ",");
            if(deleteNoBook == noBook) {
                System.out.println("[ Data Buku Yang Akan Dihapus ]");
                strToken.nextToken();
                System.out.printf("Tahun terbit : %s\n", strToken.nextToken());
                System.out.printf("Genre buku   : %s\n", strToken.nextToken());
                System.out.printf("Penulis buku : %s\n", strToken.nextToken());
                System.out.printf("Judul buku   : %s\n", strToken.nextToken());
                
                deleteBook = Another.optionYesOrNo("Are your sure to delete this book");
                foundBook = true;
            }
            
            if(deleteBook) {
                System.out.println("\nBook successfull to delete");
            }
            else {
                bufferOutput.write(dataBook);
                bufferOutput.newLine();
            }
            dataBook = bufferInput.readLine();
        }
        
        if(!foundBook) {
            System.err.println("Book not found");
        }
        
        bufferOutput.flush();
        // hapus file originDatabase
        originDatabase.delete();
        // rename file tempDatabase
        tempDatabase.renameTo(originDatabase);
        // close
        fileOutput.close();
        bufferOutput.close();
    }
    
    public static void editBook() throws IOException {
        
        // baca database asli
        File originDatabase = new File("database.txt");
        FileReader fileInput = new FileReader(originDatabase);
        BufferedReader bufferInput = new BufferedReader(fileInput);
        
        // membuat database sementara
        File tempDatabase = new File("tempDbase.txt");
        FileWriter fileOutput = new FileWriter(tempDatabase);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
        // tampilkan data buku
        displayBook();
        
        // mengambil user input 
        Scanner systemInput = new Scanner(System.in);
        System.out.print("\nMasukan no buku yang akan diubah: ");
        int editNoBook = systemInput.nextInt();
        
        // check apakah data buku yang akan diubah ada/tidak di database
        // proses merubah buku
        String dataBook = bufferInput.readLine();
        int noEntryBook = 0;
        boolean foundBook = false;
        
        while(dataBook != null) {
            boolean editBook = false;
            noEntryBook++;
            
            StringTokenizer strToken = new StringTokenizer(dataBook, ",");
            if(editNoBook == noEntryBook) {
                foundBook = true;
                System.out.println("\n[ Data Buku Yang Akan Ubah ]");
                strToken.nextToken();
                System.out.printf("Tahun terbit : %s\n", strToken.nextToken());
                System.out.printf("Genre buku   : %s\n", strToken.nextToken());
                System.out.printf("Penulis buku : %s\n", strToken.nextToken());
                System.out.printf("Judul buku   : %s\n", strToken.nextToken());
                
                editBook = Another.optionYesOrNo("Your sure to edit this book");
                if(editBook) {
                    String[] komponenBuku = {
                        "Year", "Genre", "Penulis", "Judul"
                    };
                    String[] newDataBook = new String[4];
                    // refrese strToken
                    strToken = new StringTokenizer(dataBook, ",");
                    // tampung data lama buku
                    String oldDataBook = strToken.nextToken();
                    for(int noLop = 0; noLop < komponenBuku.length; noLop++) {
                        boolean editDataBook = Another.optionYesOrNo("Ingin merubah "+komponenBuku[noLop]);
                        // refrese oldDataBook
                        oldDataBook = strToken.nextToken();
                        if(editDataBook) {
                            // refres scanner
                            systemInput = new Scanner(System.in);
                            System.out.print("Masukan "+komponenBuku[noLop]+" baru: ");
                            newDataBook[noLop] = systemInput.nextLine();
                        }
                        else {
                            newDataBook[noLop] = oldDataBook;
                        }
                    }
                    
                    strToken = new StringTokenizer(dataBook, ",");
                    System.out.println("\n[ Data Yang Anda Masukan ]");
                    strToken.nextToken();
                    System.out.println("Tahun terbit : "+strToken.nextToken()+" --> "+newDataBook[0]);
                    System.out.println("Genre buku   : "+strToken.nextToken()+" --> "+newDataBook[1]);
                    System.out.println("Penulis buku : "+strToken.nextToken()+" --> "+newDataBook[2]);
                    System.out.println("Judul buku   : "+strToken.nextToken()+" --> "+newDataBook[3]);
                
                    boolean yesOrNoEditDataBook = Another.checkBookInDbase(newDataBook, false);
                    
                    if(yesOrNoEditDataBook) {
                        System.err.println("Data yang anda masukan sudah ada di database");
                    }
                    else {
                        
                        // format baru
                        String year = newDataBook[0];
                        String genre = newDataBook[1];
                        String writer = newDataBook[2];
                        String title = newDataBook[3];
                        
                        // create primary key
                        int newEntryNoBook = Another.checkEntry(writer, year);
                        String newWriterWithNoSpace = writer.replaceAll("\\s+", "");
                        String primaryKey = String.format("%s_%s_%d", newWriterWithNoSpace, year, newEntryNoBook);
                        
                        // write to database
                        bufferOutput.write(primaryKey+","+year+","+genre+","+writer+","+title);
                    }
                }
                else {
                    bufferOutput.write(dataBook);
                }
            }
            else {
                bufferOutput.write(dataBook);
            }
            bufferOutput.newLine();
            dataBook = bufferInput.readLine();
        }
        
        if(!foundBook) {
            System.out.println("Data Buku Tidak Ditemukan");
        }
        
        bufferOutput.flush();
        originDatabase.delete();
        tempDatabase.renameTo(originDatabase);
        fileOutput.close();
        bufferOutput.close();
    }
    
}