package java.code;

import java.util.Arrays;

public class PenjumlahanArray2D {
    
    public static void main(String[] args) {
        // latihan array 2D, matrix
        
        int[][] matrixA = {
            {1,2,3}, // kolom 1
            {4,5,6}, // kolom 2
            {7,8,9}  // kolom 3
        };
        
        int[][] matrixB = {
            {10,11,12},
            {13,14,15},
            {16,17,18}
        };
        
        printValArray2D(matrixA);
        printValArray2D(matrixB);
        
        int[][] hasil = tambahValArray2D(matrixA, matrixB);
        
        printValArray2D(hasil);
    }
    
    private static int[][] tambahValArray2D(int[][] dataArray1, int[][] dataArray2) {
        int baris = dataArray1.length;
        int kolom = dataArray1[0].length;
        
        int[][] hasil = new int[baris][kolom];
        
        for(int lop1 = 0; lop1 < baris; lop1++) {
            for(int lop2 = 0; lop2 < kolom; lop2++) {
                hasil[lop1][lop2] = dataArray1[lop1][lop2] + dataArray2[lop1][lop2];
            }
        }
        
        return hasil;
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