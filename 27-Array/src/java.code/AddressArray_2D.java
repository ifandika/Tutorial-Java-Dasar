package java.code;

import java.util.Arrays;

public class AddressArray_2D {
    
    public static void main(String[] args) {
        
        // address array pada 2D
        
        // array 1D
        int[] intRay_1D = {1,2,3};
        
        // akan menampilkan addrss dari data array ke index[0]
        System.out.println("intRay_1D -> " + intRay_1D);
        
        
        // membuat array 2D
        // size pada array 2D boleh berapapun, data pada array 2D tidak bersambung
        int[][] intRay_2D = {
            {1,2,3}, // kolom 1
            {4,5,6}, // kolom 2
        };
        // arsitektur address pada array 2D
        // address -> intRay_2D[ A01 -> address header
        //     intRay_2D[0] A02 -> address dari intRay_2D kolom 1
        //    
        //     intRay_2D[1] A03 -> address dari intRay_2D kolom 2
        // ]
        
        // akan menampilkan address dari header array 2D
        System.out.println("\nintRay_2D -> " + intRay_2D);
        System.out.println("intRay_2D kolom 0 -> " + intRay_2D[0]);
        System.out.println("intRay_2D kolom 1 -> " + intRay_2D[1]);
        
        System.out.println("\n menampilkan data array");
        System.out.println("data intRay_1D : " + Arrays.toString(intRay_1D)); // toString() untuk array 1D
        System.out.println("data intRay_2D : " + Arrays.deepToString(intRay_2D)); // deepToString() untuk array 2D
        
        // cara lain membuat array 2D
        char[] charRay1_1D = {'A','B'};
        char[] charRay2_1D = {'C','D'};
        
        char[][] charRay_2D = {
            
            charRay1_1D,
            charRay2_1D,
        };
        
        System.out.println("data charRay_2D : " + Arrays.deepToString(charRay_2D));
        
    }
}