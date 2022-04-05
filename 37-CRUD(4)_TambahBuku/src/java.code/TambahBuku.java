package java.code;

import java.util.Arrays;
import java.time.Year;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.StringTokenizer;

/**
 * @param ifandika
 * kesimpulan
 * - tidak semua delimiter dapat berfungsi dengan baik
 * - contoh delimiter yang baik : [ . , _ ]
 * 
 * 
 */

// CRUD Part 4 | Menambah Buku
public class TambahBuku {
    // global scope class Menu
    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        
        menu();
    }
    
    private static void menu() throws IOException {

        String dataInput;
        boolean isContinue = true;
        
        berhenti: while(isContinue) {
            clearScreen();
            System.out.println("[ PROJECT PERPUSTAKAAN ]\n");
            System.out.println("1. [ Lihat Buku ]");
            System.out.println("2. [ Cari Buku ]");
            System.out.println("3. [ Tambah Buku ]");
            System.out.println("4. [ Edit Buku ]");
            System.out.println("5. [ Hapus Buku ]");
            System.out.println("0. [ Keluar ]");
            System.out.print("\n\nPilih menu : ");
            dataInput = userInput.next();
            
            switch(dataInput) {
                case "1":
                    System.out.println("[ LIHAT SEMUA BUKU ]\n");
                    displayBook();
                    break;
                case "2":
                    System.out.println("[ CARI BUKU ]\n");
                    cariBuku();
                    break;
                case "3":
                    System.out.println("[ TAMBAH BUKU ]\n");
                    tambahBuku();
                    break;
                case "4":
                    System.out.println("[ EDIT BUKU ]\n");
                    break;
                case "5":
                    System.out.println("[ HAPUS BUKU ]\n");
                    break;
                case "0":
                    isContinue = optionYesOrNo("Yakin ingin keluar");
                    if(isContinue) { break berhenti; }
                    else { isContinue = true; continue; }
                default:
                    System.err.println("input tidak ada. harap coba lagi\n");
            }
            isContinue = optionYesOrNo("Lanjutkan");
        }
    }
    
    private static boolean optionYesOrNo(String message) {

        System.out.printf("\n%s (y/n): ", message);
        String inputUser = userInput.next();

        while(!inputUser.equalsIgnoreCase("y") && !inputUser.equalsIgnoreCase("n")) {
            System.err.println("Input Yang Dimasukan Tidak Benar");
            System.out.printf("\n%s (y/n): ", message);
            inputUser = userInput.next();
        }
        return inputUser.equalsIgnoreCase("y");
    }

    private static void clearScreen() {
        
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
            System.out.println("Gagal clear terminal");
        }
    }

    private static void displayBook() throws IOException {
        
        FileReader fileInput;
        BufferedReader bufferInput;
        
        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        }
        catch(IOException message) {
            System.out.println(message);
            System.out.println("data buku kosong, harap isi data buku");
            return;
        }
        String dataBuku = bufferInput.readLine();
        int noBuku = 0;

        System.out.println("| NO | TAHUN |    GENRE    |   PENULIS  |     JUDUL");
        System.out.println("--------------------------------------------------------------");
        while(dataBuku != null) {
            StringTokenizer strToken = new StringTokenizer(dataBuku, ",");
            noBuku++;
            
            System.out.printf("|%-4d", noBuku);
            strToken.nextToken();
            System.out.printf("|%-7s", strToken.nextToken());
            System.out.printf("|%-13s", strToken.nextToken());
            System.out.printf("|%-12s", strToken.nextToken());
            System.out.printf("|%s\n", strToken.nextToken());
            
            dataBuku = bufferInput.readLine();
        }
        System.out.println("--------------------------------------------------------------");
    }
    
    private static void cariBuku() throws IOException {
        
        try {
            File dBase = new File("database.txt");
        }
        catch(Exception message) {
            System.err.println("data buku kosong, silahkan isi data buku");
            return;
        }
        userInput = new Scanner(System.in);
        System.out.print("masukan kata kunci: ");
        String dataKey = userInput.nextLine();
        String[] rayDataKey = dataKey.split("//s+");
        
        checkBukuDiDatabase(rayDataKey, true);
    }
    
    private static boolean checkBukuDiDatabase(String[] dataKeyword, boolean isDisplay) throws IOException {

        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String dataBuku = bufferInput.readLine();
        int noBuku = 0;
        boolean hasilKeyword = false;

        if(isDisplay) {
            System.out.println("| NO | TAHUN |    GENRE    |   PENULIS  |     JUDUL");
            System.out.println("--------------------------------------------------------------");
        }
        while(dataBuku != null) {
            hasilKeyword = true;
            for(String data : dataKeyword) {
                hasilKeyword = hasilKeyword && dataBuku.toLowerCase().contains(data.toLowerCase());
            }
            if(hasilKeyword) {
                if(isDisplay) {
                    StringTokenizer strToken = new StringTokenizer(dataBuku, ",");
                    noBuku++;
                    System.out.printf("|%-4d", noBuku);
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
            dataBuku = bufferInput.readLine();
        }
        if(isDisplay) {
            System.out.println("--------------------------------------------------------------");
        }
        return hasilKeyword;
    }
    
    private static int checkEntry(String penulis, String tahun) throws IOException {
        
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        
        String data = bufferInput.readLine();
        String primaryKey;
        int entry = 0;
        Scanner scanner;
        
        while(data != null) {
            scanner = new Scanner(data);
            scanner.useDelimiter(",");
            primaryKey = scanner.next();
            scanner = new Scanner(primaryKey);
            scanner.useDelimiter("_"); 
            
            penulis = penulis.replaceAll("//s+", "");
            if(penulis.equalsIgnoreCase(scanner.next()) && tahun.equalsIgnoreCase(scanner.next())) {
                entry = scanner.nextInt();
            }
            data = bufferInput.readLine();
        }
        
        return entry;
    }
    
    private static String checkTahun() throws IOException {
        boolean tahunValid = false;
        userInput = new Scanner(System.in);
        String inputTahun = userInput.nextLine();
        
        while(!tahunValid) {
            try {
                Year.parse(inputTahun);
                tahunValid = true;
            }
            catch(Exception e) {
                System.err.println("Format tahun tidak valid");
                inputTahun = userInput.nextLine();
                tahunValid = false;
            }
        }
        
        return inputTahun;
    }
    
    private static void tambahBuku() throws IOException {
        
        //                                      nameFile     |  mode
        FileWriter fileOutput = new FileWriter("database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
        userInput = new Scanner(System.in);
        String penulis, tahun, genre, judulBuku;
        
        // entry = data keberapa, contoh data ke 1,2,...
        System.out.print("masukan judul buku   : ");
        judulBuku = userInput.nextLine();
        System.out.print("masukan nama penulis : ");
        penulis = userInput.nextLine();
        System.out.print("masukan nama genre   : ");
        genre = userInput.nextLine();
        System.out.print("masukan tahun terbit : ");
        tahun = checkTahun();
        
        String[] dataInput = {
            tahun+","+genre+","+penulis+","+judulBuku
        };
        boolean hasil = checkBukuDiDatabase(dataInput, false);

        if(!hasil) {
            int entry = checkEntry(penulis, tahun) + 1;
            String penulisTampaSpasi = penulis.replaceAll("//s+", "");
            String primaryKey = String.format("%s_%s_%d", penulisTampaSpasi, tahun, entry);
            
            System.out.println("\n[ data yang dimasukan ]");
            System.out.printf("primary key  : %s\n", primaryKey);
            System.out.printf("judul buku   : %s\n", judulBuku);
            System.out.printf("nama penulis : %s\n", penulis);
            System.out.printf("genre buku   : %s\n", genre);
            System.out.printf("tahun terbit : %s\n", tahun);
            
            boolean writeOrNo = optionYesOrNo("simpan di database");
            if(writeOrNo) {
                bufferOutput.write(primaryKey+","+tahun+","+genre+","+penulis+","+judulBuku);
                bufferOutput.newLine();
                bufferOutput.flush();
            }
        }
        else {
            System.out.println("data buku sudah ada, silahkan masukan data buku lain");
            checkBukuDiDatabase(dataInput, true);
        }
        bufferOutput.close();
    }
    
}