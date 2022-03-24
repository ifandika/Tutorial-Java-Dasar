package java.code;

import java.io.FileInputStream;
import java.io.IOException;

public class Pengenalan_IOFile {
    
    public static void main(String[] args) throws IOException {
        
        FileInputStream fileInput = new FileInputStream("data.txt");
        
        // struktur databse
        // - jika pada file.java maka harus selevel dengan folder sebelum package = contoh ( src )
        // - jika pada file.class maka harus selevel dengan folder package
        // - jika pada file.jar maka harus selevel dengan file.jar
        
        // membaca data file
        System.out.println((char)fileInput.read());
        
        
    }
}