package java.code;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

// CRUD Part 2 | Menampilkan Buku
public class LihatBuku {
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
                    break;
                case "3":
                    System.out.println("[ TAMBAH BUKU ]\n");
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
    
}