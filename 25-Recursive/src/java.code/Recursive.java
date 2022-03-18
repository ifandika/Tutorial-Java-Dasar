package java.code;

import java.util.Scanner;

public class Recursive {
    
    public static void main(String[] args) {
        
        // recursive/rekursif = fungsi yang memanggil diri sendiri
        
        // contoh recursive dengan faktorial
        Scanner input = new Scanner(System.in);
        
        int nilai;
        
        System.out.print("Masukan nilai faktorial : ");
        nilai = input.nextInt();
        
        System.out.println(recursive(nilai));
        
        
    }
    
    static int recursive(int data) {
        if(data <= 1) {
            return 1;
        }
        else {
            return data * recursive(data - 1);
        }
    }
}
