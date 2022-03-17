package java.code;

import java.util.Scanner;

public class SwitchCase {
    
    public static void main(String[] args) {
        
        // switch case
        
        Scanner input = new Scanner(System.in);
        char nilaiTest;
        
        System.out.print("masukan nilai test : ");
        nilaiTest = input.next().charAt(0);
        
        //    ( kondisi )
        switch(nilaiTest) {
            case 'A':
                System.out.println("selamat anda lulus");
                break;
            case 'B':
                System.out.println("nilai anda bagus");
                break;
            case 'C':
                System.out.println("jangan lupa belajar");
                break;
            default:
                System.out.println("nilai tidak valid");
        }
        
    }
}