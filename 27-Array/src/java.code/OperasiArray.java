package java.code;

import java.util.Arrays;

public class OperasiArray {
    
    public static void main(String[] args) {
        
        // operasi pada array
        
        System.out.println("\n[ Sorting Array ]\n");
        int[] valRay5 = {0,9,5,7,3,8,6,2,1,4};
        
        // Arrays.sort(varArray);
        printValArray(valRay5);
        Arrays.sort(valRay5);
        printValArray(valRay5);
        
        System.out.println("\n[ fill ]");
        // menjadika semua data/elemen array menjadi nilai berapapun yang diinginkan
        int[] noKos = new int[10];
        
        printValArray(noKos);
        Arrays.fill(noKos, 1); // data pada array noKos menjadi nilai 1 semua
        
        printValArray(noKos);
        
        System.out.println("\n[ Search ]");
        // mencari data pada array, dan index ke berapa
        int[] noUndian = {0,6,4,3,9,1,2,5,8,7};
        // namun jika ingin search maka kita harus sorting dulu
        // search data array sesudah sorting
        Arrays.sort(noUndian);
        // search
        int noCari = 7;
        
        System.out.println(Arrays.binarySearch(noUndian, noCari));
        
        System.out.println("\n[ Equals ]");
        // membadingkan dua buah array
        byte[] nilaiSiswa1 = {80, 90,50, 45, 75};
        byte[] nilaiSiswa2 = {81, 90,50, 45, 75};
        
        if(Arrays.equals(nilaiSiswa1, nilaiSiswa2)) {
            System.out.println("sama");
        }
        else {
            System.out.println("tidak");
        }
        
        
    }
    
    private static void printValArray(int[] dataArray) {
        // convert all type data array to print String
        System.out.println("value array -> " + Arrays.toString(dataArray));
    }
}
