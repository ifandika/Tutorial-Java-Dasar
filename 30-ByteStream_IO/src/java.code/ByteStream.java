package java.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    
    public static void main(String[] args) throws IOException {
        
        FileInputStream fileInput = null; // -> kosong
        
        // membuka file
        fileInput = new FileInputStream("data.txt");
        
        // membaca data secara keseluruhan
        
        int data1 = fileInput.read();
        
        // membaca file
        while(data1 != -1) {
            System.out.println((char)data1);
            // refresh
            data1 = fileInput.read();
        }
        // menutup file
        fileInput.close();
        
        // contoh dengan try, jika sudah ada throws maka tidak usah menggunakan catch
        
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        
        try {
            // membuka file
            fileIn = new FileInputStream("input.txt");
            fileOut = new FileOutputStream("output.txt");
            
            // membaca file
            int data2 = fileIn.read();
            
            // menulis file
            while(data2 != -1) {
                fileOut.wrire(data2);
                data2 = fileIn.read();
            }
            
        }
        finally {
            // check jika file terbuka maka kita tutup
            if(fileIn != null || fileOut != null) {
                fileIn.close();
            }
        }
        
        // contoh tampa finally -> try with resource
        // jika dengan try with resource maka tidak perlu menutup objek
        try (FileInputStream fInput = new FileInputStream("input.txt")) {
            
            int dataHuruf = fInput.read();
            
            while(dataHuruf != -1) {
                System.out.print((char)dataHuruf);
                
                dataHuruf = fInput.read();
            }
        }
        
        
    }
}