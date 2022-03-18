package java.code;

// library class / package Array
import java.util.Arrays;

public class Array {
    
    public static void main(String[] args) {
        
        // Array = sekumpulan data, data yang menyimpan sekumpulan data dengan tipe data yang sama 
        // alokasi memory array pada java berada di heap
        
        int array1[] = new int[3]; // membuat deklarasi array dengan keyword new
        // array1 = new int[3];
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        
        System.out.println("array 1 = " + array1[0]);
        System.out.println("array 2 = " + array1[1]);
        System.out.println("array 3 = " + array1[2]);
        
        // membuat array dengan String
        String[] array2 = {
            "Ucup", "Kipli", "Jupri"
        };
        
        System.out.println("\narray 1 = " + array2[0]);
        System.out.println("array 2 = " + array2[1]);
        System.out.println("array 3 = " + array2[2]);
        
        // print semua data array ke bentuk string .toString()
        System.out.println(Arrays.toString(array1));
        
        int[] valRay1 = {1,2,3,4,5}; // langsung me assignment nilai
        int[] valRay2 = new int[5]; // hanya membuat deklarasi array, jika nilai tidak di isi maka default 0
        
        // akan menghasilkan address dari valRay1
        System.out.println("address valRay1 -> " + valRay1);
        System.out.println("address valRay2 -> " + valRay2);
        
        // tidak mengcopy value/nilai dari valRay1, namun akan mengirim address dari valRay1
        // sehingga jika data pada valRay2 di ubah maka data pada valRat1 akan ikut berubah
        valRay2 = valRay1; // valRay2 akan menunjuk address valRay1
        
        System.out.println("valRay1 -> " + Arrays.toString(valRay1));
        System.out.println("valRay2 -> " + Arrays.toString(valRay2));
        
        System.out.println("address valRay1 -> " + valRay1);
        System.out.println("address valRay2 -> " + valRay2);
        
        // merubah data pada valRay1
        valRay1[0] = 100;
        
        System.out.println("valRay1 -> " + Arrays.toString(valRay1));
        System.out.println("valRay2 -> " + Arrays.toString(valRay2));
        
        // walaupun merubah pada method maka pada parameter yang di kirim bukam nilai namun address/refrence
        ubahDataArray(valRay1);
        
        System.out.println("valRay1 -> " + Arrays.toString(valRay1));
        System.out.println("valRay2 -> " + Arrays.toString(valRay2));
        
    }
    
    // method merubah data array, argumen pas by refrence, bukan pas by value
    private static void ubahDataArray(int[] dataArray) {
        dataArray[0] = 300;
    }
}
