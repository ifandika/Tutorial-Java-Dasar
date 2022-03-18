package java.code;

import java.util.Arrays;

public class PengenalanString {
    
    public static void main(String[] args) {
        
        // String pada java disebut object/high level tipe data
        
        // memory pada java
        // stack | heap | String Pool(Khusus Untuk String)
        
        String namaStr = "Kipli"; // string
        char[] namaChar = {'K','i','p','l','i'}; // char array
        
        // menampilkan
        System.out.printf("namaStr  : %s\n", namaStr);
        System.out.println("namaChar : " + Arrays.toString(namaChar));
        
        // menampilkan data pada index
        System.out.println("\nnamaStr  : " + namaStr.charAt(0));
        System.out.println("namaChar : " + namaChar[0]);
        
        
        // merubah data 
        namaChar[0] = 'J';
        // namaStr[0] = "J"; --> tidak bisa di lakukan, karena String di java immutable
        
        System.out.println("namaChar : " + Arrays.toString(namaChar));
        
        // menampilkan address
        System.out.println("\nnamaChar| " + namaChar);
        printDataString("namaStr", namaStr);
        
        // jika kita merubah data pada string, maka kita tidak merubah data nya melainkan
        // membuat string baru dengan data yang baru
        
        // cara merubah data string denga .subString()
        
        printDataString("\nnamaStr", namaStr); // sebelum
        namaStr = "c" + namaStr.substring(0,4); // maka address akan berubah
        printDataString("namaStr", namaStr); // sesudah 
        
        System.out.println();
        
        // jika data pada string sama maka address akab sama
        String data1 = "hello";
        String data2 = "hello";
        // data1 & data2 = address akan sama --> Alokasi Memory String Pool
        String data3 = "c" + data1.substring(0,4); // membuat string dengan method maka alokasi memory bukan di string pool
        
        printDataString("data1", data1);
        printDataString("data2", data2);
        printDataString("data3", data3);
        
        // membuat string dan mengalokasikan di heap
        String heapStr = new String("ini string di heap");
        
        printDataString("\nheapStr", heapStr);
    }
    
    private static void printDataString(String nama, String data) {
        int address = System.identityHashCode(data);
        System.out.println(nama + " | address : " + Integer.toHexString(address));
    }
}
