package code;

import java.util.Scanner;

public class PengenalanException {
    
    public static void main(String[] args) {
        
        // Exception / Error Handling
        // keyword try, catch, finally
        // try -> mencoba, coba sesuatu yang menyebabkan error
        // catch -> menangkap error yang di hasilkan dari try
        // finally -> 
        
        Scanner input = new Scanner(System.in);
        short nilai;
        short[] numRay = {0,1,2,3,4};
        
        System.out.print("masukan nilai array ke : ");
        nilai = input.nextShort();
        
        // panjang array 5, jika memsukan >= 5 maka akan error 
        
        try { // try 
            // jika ini menyebabkan eror maka akan di tangkap oleh catch
            System.out.printf("nilai array ke%d, -> %d\n", nilai, numRay[nilai]);
        // atau bisa juga kita isi pada parameter dengan pesan error
        // contoh error berupa nilai yang di masukan tidak sesuai dengan panjang array
        // ArrayIndexOutOfBoundsException
        }catch(Exception erorExcep) { // akan menangkap error, catch bisa lebih dari 1
         // System.err.
            System.out.println(erorExcep.getMessage()); // .getMessage() untuk menampilkan poin utama dari error
        }
        
    }
}