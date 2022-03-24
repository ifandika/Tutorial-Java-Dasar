package java.code;

// import java.io.*;
import java.io.IOException;
import java.io.FileInputStream; // byte stream
import java.io.FileOutputStream; // byte stream
import java.io.FileReader; // character stream
import java.io.FileWriter; // character stream

public class CharacterStream {
    
    public static void main(String[] args) throws IOException {
        
        // jika byte stream, jika bahasa yang digunakan bahasa inter maka nilai ASCII berbeda
        //  sehingga jika di output kan maka hasilnya tidak sesuai, namun jika untuk menulis masih bisa
        // jika character stream, walau bahasa yang digunakan bahasa inter maka untuk menulis ke file lain
        //  , dan di display maka masih sama
        
        // membuka file
        FileInputStream byteFileIn = new FileInputStream("data.txt");
        FileReader charFileIn = new FileReader("data.txt");
        
        FileOutputStream byteFileOut = new FileOutputStream("outputByte.txt");
        FileWriter charFileOut = new FileWriter("outputChar.txt");
        
        // membaca file dan menulis file
        int dataFile = byteFileIn.read();
        
        /* byte stream */
        while(dataFile != -1) {
            System.out.print((char)dataFile);
            
            byteFileOut.write(dataFile); // write file
            
            dataFile = byteFileIn.read();
        }
        
        System.out.println("\n");
        dataFile = charFileIn.read();
        
        /* character stream */
        while(dataFile != -1) {
            System.out.print((char)dataFile);
            
            charFileOut.write(dataFile);
            
            dataFile = charFileIn.read();
        }
        
        // close file
        byteFileIn.close();
        charFileIn.close();
        byteFileOut.close();
        charFileOut.close();
    }
}