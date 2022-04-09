package java.code;

import java.io.IOException;
import java.util.Scanner;

import com.crud.Another;
import com.crud.Operation;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        String dataInput;
        boolean isContinue = true;
        
        stop: while(isContinue) {
            Another.clearScreen();
            System.out.println("[ PROJECT PERPUSTAKAAN ]\n");
            System.out.println("1. [ Lihat Buku ]");
            System.out.println("2. [ Cari Buku ]");
            System.out.println("3. [ Tambah Buku ]");
            System.out.println("4. [ Edit Buku ]");
            System.out.println("5. [ Hapus Buku ]");
            System.out.println("0. [ Keluar ]");
            System.out.print("\n\nPilih menu : ");
            dataInput = input.next();
            
            switch(dataInput) {
                case "1":
                    System.out.println("[ LIHAT SEMUA BUKU ]\n");
                    Operation.displayBook();
                    break;
                case "2":
                    System.out.println("[ CARI BUKU ]\n");
                    Operation.searchBook();
                    break;
                case "3":
                    System.out.println("[ TAMBAH BUKU ]\n");
                    Operation.addBook();
                    break;
                case "4":
                    System.out.println("[ EDIT BUKU ]\n");
                    Operation.editBook();
                    break;
                case "5":
                    System.out.println("[ HAPUS BUKU ]\n");
                    Operation.deleteBook();
                    break;
                case "0":
                    isContinue = Another.optionYesOrNo("Yakin ingin keluar");
                    if(isContinue) {
                        break stop; 
                    }
                    else {
                        isContinue = true; 
                        continue; 
                    }
                default:
                    System.err.println("input tidak ada. harap coba lagi\n");
            }
            isContinue = Another.optionYesOrNo("Lanjutkan");
        }
    }
}