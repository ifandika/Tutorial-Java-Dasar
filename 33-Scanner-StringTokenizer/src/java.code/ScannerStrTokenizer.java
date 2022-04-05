package java.code;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScannerStrTokenizer {
    
    public static void main(String[] args) throws IOException {
        
        FileReader fileRead = new FileReader("data1.txt");
        BufferedReader bufferRead = new BufferedReader(fileRead);
        // Scanner untuk membaca data file
        Scanner readData = new Scanner(bufferRead);
        
        System.out.println(readData.hasNext() + "\n"); // mengecek apakah ada kalimat atau tidak
        
        // .next() membaca per 1 kalimat, dgn delimiter/pemisah spasi
        System.out.println(readData.next());
        System.out.println(readData.next());
        System.out.println(readData.next());
        System.out.println(readData.next());
        System.out.println(readData.next());
        
        System.out.println("\n" + readData.hasNext());
        
        System.out.println("==========");
        
        // membaca dengan delimiter tertentu
        // jika menggunakan .useDelimiter(deli) bertujuan untuk mengghilangkan tanda pemisah
        FileReader fileRead2 = new FileReader("data2.txt");
        bufferRead = new BufferedReader(fileRead2);
        bufferRead.mark(200);
        readData = new Scanner(bufferRead);
        // contoh delimiter koma
        readData.useDelimiter(","); // maka saat membaca data tanda , dihilangkan di output
        
        // akan membaca semua data
        while(readData.hasNext()) {
            System.out.print(readData.next() + " ");
        }
        
        System.out.println("\n===========");
        
        // menggunakan String Tokenizer
        // String Tokenizer membaca per kalimat
        bufferRead.reset();
        String data = bufferRead.readLine();
        System.out.println(data);
        
        StringTokenizer stringToken = new StringTokenizer(data, ",");
        
        // membaca baris ke 1
        while(stringToken.hasMoreTokens()) {
            System.out.println(stringToken.nextToken());
        }
        
        System.out.println();
        // membaca baris ke 2
        data = bufferRead.readLine();
        System.out.println(data);
        stringToken = new StringTokenizer(data, ",");
        
        while(stringToken.hasMoreTokens()) {
            System.out.println(stringToken.nextToken());
        }
        
    }
}