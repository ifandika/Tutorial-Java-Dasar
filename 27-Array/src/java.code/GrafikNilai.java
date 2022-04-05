package java.code;

import java.util.*;

public class GrafikNilai {
    
    public static void main(String[] args) {
        
        int[] nilai = new int[10];
        
        inputNilai(nilai);
        
        outputNilaiByGrafik(nilai);
        
    }
    
    private static void inputNilai(int[] data) {
        Scanner input = new Scanner(System.in);
         
        // input nilai from user
        for(int lop = 0; lop < data.length; lop++) {
            System.out.print("masukan nilai siswa ");
            
            if(lop == 0) {
                System.out.print("[0 - 9] : ");
            }
            else if(lop == 9) {
                System.out.print("[" + (lop*10) + "-100]: ");
            }
            else {
                System.out.print("[" + (lop*10) + "-" + ((lop*10)+9) + "] : ");
            }
            
            data[lop] = input.nextInt();
        }
    }
    
    private static void outputNilaiByGrafik(int[] data) {
        System.out.println("\nGrafik Nilai Siswa\n");
        
        for(int lop = 0; lop < data.length; lop++) {
            System.out.print("grafik nilai siswa ");
            
            if(lop == 0) {
                System.out.print("[0 - 9] : ");
            }
            else if(lop == 9) {
                System.out.print("[" + (lop*10) + "-100]: ");
            }
            else {
                System.out.print("[" + (lop*10) + "-" + ((lop*10)+9) + "] : ");
            }
            
            for(int grafik = 0; grafik < data[lop]; grafik++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}
