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

// CRUD Part 6 | Meubah Buku
public class UbahBuku {
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
                    ubahDataBuku();
                    break;
                case "5":
                    System.out.println("[ HAPUS BUKU ]\n");
                    hapusBuku();
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
        String[] rayDataKey = dataKey.split("\\s+");
        
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
            
            penulis = penulis.replaceAll("\\s+", "");
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
            String penulisTampaSpasi = penulis.replaceAll("\\s+", "");
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
    
    private static void hapusBuku() throws IOException {
        
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
        userInput = new Scanner(System.in);
        System.out.print("Masukan no buku yang akan dihapus: ");
        int noHapusBuku = userInput.nextInt();
        
        // check buku yang akan dihapus di database
        String dataBuku = bufferInput.readLine();
        int noBuku = 0;
        
        boolean foundBuku = false;
        
        while(dataBuku != null) {
            boolean hapusBuku = false;
            noBuku++;
            
            StringTokenizer strToken = new StringTokenizer(dataBuku, ",");
            if(noHapusBuku == noBuku) {
                System.out.println("[ Data Buku Yang Akan Dihapus ]");
                strToken.nextToken();
                System.out.printf("Tahun terbit : %s\n", strToken.nextToken());
                System.out.printf("Genre buku   : %s\n", strToken.nextToken());
                System.out.printf("Penulis buku : %s\n", strToken.nextToken());
                System.out.printf("Judul buku   : %s\n", strToken.nextToken());
                
                hapusBuku = optionYesOrNo("Yakin ingin menghapus buku ini");
                foundBuku = true;
            }
            
            if(hapusBuku) {
                System.out.println("\nData Buku berhasil dihapus");
            }
            else {
                bufferOutput.write(dataBuku);
                bufferOutput.newLine();
            }
            dataBuku = bufferInput.readLine();
        }
        
        if(!foundBuku) {
            System.err.println("Data Buku tidak ditemukan");
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
    
    private static void ubahDataBuku() throws IOException {
        
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
        userInput = new Scanner(System.in);
        System.out.print("\nMasukan no buku yang akan diubah: ");
        int noUbahBuku = userInput.nextInt();
        
        // check apakah data buku yang akan diubah ada/tidak di database
        String dataBuku = bufferInput.readLine();
        int noEntryBuku = 0;
        boolean foundDataBuku = false;
        
        while(dataBuku != null) {
            boolean ubahBuku = false;
            noEntryBuku++;
            
            StringTokenizer strToken = new StringTokenizer(dataBuku, ",");
            if(noUbahBuku == noEntryBuku) {
                foundDataBuku = true;
                System.out.println("\n[ Data Buku Yang Akan Ubah ]");
                strToken.nextToken();
                System.out.printf("Tahun terbit : %s\n", strToken.nextToken());
                System.out.printf("Genre buku   : %s\n", strToken.nextToken());
                System.out.printf("Penulis buku : %s\n", strToken.nextToken());
                System.out.printf("Judul buku   : %s\n", strToken.nextToken());
                
                ubahBuku = optionYesOrNo("Ingin merubah data buku tersebut");
                if(ubahBuku) {
                    String[] komponenBuku = {
                        "Tahun", "Genre", "Penulis", "Judul"
                    };
                    String[] dataBukuBaru = new String[4];
                    // refrese strToken
                    strToken = new StringTokenizer(dataBuku, ",");
                    // tampung data lama buku
                    String dataBukuLama = strToken.nextToken();
                    for(int noLop = 0; noLop < komponenBuku.length; noLop++) {
                        boolean ubahKomponenBuku = optionYesOrNo("Ingin merubah "+komponenBuku[noLop]);
                        // refrese dataLamaBuku
                        dataBukuLama = strToken.nextToken();
                        if(ubahKomponenBuku) {
                            // refres scanner
                            userInput = new Scanner(System.in);
                            System.out.print("Masukan "+komponenBuku[noLop]+" baru: ");
                            dataBukuBaru[noLop] = userInput.nextLine();
                        }
                        else {
                            dataBukuBaru[noLop] = dataBukuLama;
                        }
                    }
                    
                    strToken = new StringTokenizer(dataBuku, ",");
                    System.out.println("\n[ Data Yang Anda Masukan ]");
                    strToken.nextToken();
                    System.out.println("Tahun terbit : "+strToken.nextToken()+" --> "+dataBukuBaru[0]);
                    System.out.println("Genre buku   : "+strToken.nextToken()+" --> "+dataBukuBaru[1]);
                    System.out.println("Penulis buku : "+strToken.nextToken()+" --> "+dataBukuBaru[2]);
                    System.out.println("Judul buku   : "+strToken.nextToken()+" --> "+dataBukuBaru[3]);
                
                    boolean perbaruiDataBuku = checkBukuDiDatabase(dataBukuBaru, false);
                    
                    if(perbaruiDataBuku) {
                        System.err.println("Data yang anda masukan sudah ada di database");
                    }
                    else {
                        
                        // format baru
                        String tahun = dataBukuBaru[0];
                        String genre = dataBukuBaru[1];
                        String penulis = dataBukuBaru[2];
                        String judul = dataBukuBaru[3];
                        
                        // create primary key
                        int entry = checkEntry(penulis, tahun);
                        String penulisTampaSpasi = penulis.replaceAll("\\s+", "");
                        String primaryKey = String.format("%s_%s_%d", penulisTampaSpasi, tahun, entry);
                        
                        // write to database
                        bufferOutput.write(primaryKey+","+tahun+","+genre+","+penulis+","+judul);
                    }
                }
                else {
                    bufferOutput.write(dataBuku);
                }
            }
            else {
                bufferOutput.write(dataBuku);
            }
            bufferOutput.newLine();
            dataBuku = bufferInput.readLine();
        }
        
        if(!foundDataBuku) {
            System.out.println("Data Buku Tidak Ditemukan");
        }
        
        bufferOutput.flush();
        originDatabase.delete();
        tempDatabase.renameTo(originDatabase);
        fileOutput.close();
        bufferOutput.close();
    }
}