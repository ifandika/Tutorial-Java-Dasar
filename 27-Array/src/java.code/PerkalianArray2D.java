package java.code;

import java.util.Arrays;

public class PerkalianArray2D {
    
    public static void main(String[] args) {
        
        // perkalian array 2D / matrix
        
        int[][] matrixA = {
            {1, 2},
            {3, 4},
        };
        int[][] matrixB = {
            {5, 6},
            {7, 8},
        };
        
        printValArray2D(matrixA);
        printValArray2D(matrixB);
        
        int[][] hasil = kaliValArray2D(matrixA, matrixB);
        
        printValArray2D(hasil);
        
        // rumus perkalian matrix 
        // kolom = banyak angka, objek pada satu baris
        // baris = banyaknya baris pada satu buah matrix
        // syarat terjadinya perkalian matrix adalah jika jumlah kolom sama dengan jumlah baris
        // . = operator perkalian
        /**
        * [ A1(1), A2(2) ]   [ B1(5), B2(6) ]    [ Hasil1, Hasil2 ]
        * [ A3(3), A4(4) ] . [ B3(7), B4(8) ] =  [ Hasil3, Hasil4 ]
        *
        * perhitungan
        * [ A1(1).B1(5) + A2(2).B3(7)  A1(1).B2(6) + A2(2).B4(8) ]
        * [ A3(3).B1(5) + A4(4).B3(7)  A3(3).B2(8) + A4(4).B4(8) ]
        *
        * [ Hasil1(19)  Hasil2(22) ]
        * [ Hasil3(43)  Hasil4(50) ]
        */
    }
    
    private static int[][] kaliValArray2D(int[][] dataArray1, int[][] dataArray2) {
        int baris1 = dataArray1.length;
        int kolom1 = dataArray1[0].length;
        
        int baris2 = dataArray2.length;
        int kolom2 = dataArray2[0].length;
        
        int[][] hasilAkhir = new int[baris1][kolom2];
        
        int hasilKali;
        
        for(int lop1 = 0; lop1 < baris1; lop1++) {
            for(int lop2 = 0; lop2 < kolom2; lop2++) {
                hasilKali = 0; // setiap selesai mengkalikan maka kita reset menjadi 0
                for(int lop3 = 0; lop3 < kolom1; lop3++) {
                    hasilKali += dataArray1[lop1][lop3] * dataArray2[lop3][lop2];
                }
                hasilAkhir[lop1][lop2] = hasilKali;
            }
        }
        
        return hasilAkhir;
    }
    
    private static void printValArray2D(int[][] dataArray) {
        int baris = dataArray.length;
        int kolom = dataArray[0].length;
        
        for(int lop1 = 0; lop1 < baris; lop1++) {
            System.out.print("[");
            
            for(int lop2 = 0; lop2 < kolom; lop2++) {
                System.out.print(dataArray[lop1][lop2]);
                if(lop2 < (kolom - 1)) {
                    System.out.print(",");
                }
                else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}