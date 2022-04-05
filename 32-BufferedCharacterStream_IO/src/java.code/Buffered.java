package java.code;

import java.util.Arrays;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Buffered {
    
    public static void main(String[] args) throws IOException {
        
        // Buffered Stream Input Output
        FileReader fileInput = new FileReader("input.txt");
        // buffered
        BufferedReader bufferRead = new BufferedReader(fileInput);
        bufferRead.mark(200);
        
        // membaca per line dan dimasukan ke dalam string
        String data = bufferRead.readLine();
        System.out.println(data);
        
        // setiap selesai membaca maka kita harus me reset agar kembali ke awal
        bufferRead.reset();
        
        // membaca per karakter dan memsukan ke dalam char[]
        char[] dataChar = new char[26];
        bufferRead.read(dataChar, 0, 26); // memasukan data ke char[]
        System.out.println(Arrays.toString(dataChar));
        
        bufferRead.reset();
        System.out.println((char)bufferRead.read()); // membaca per kata
        System.out.println();
        
        bufferRead.reset();
        
        // menulis data ke file
        // pada FileWriter terdapat mode untuk menulis ke database
        FileWriter fileOutput = new FileWriter("output.txt");
        BufferedWriter bufferWrite = new BufferedWriter(fileOutput);
        
        String data1 = bufferRead.readLine();
        bufferWrite.write(data1);
        // lalu kita flush() agar menulis ke file
        bufferWrite.flush();
        
        fileInput.close();
        fileOutput.close();
        bufferRead.close();
        bufferWrite.close();
        
    }
}