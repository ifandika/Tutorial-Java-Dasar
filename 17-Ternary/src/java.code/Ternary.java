package java.code;

import java.util.Scanner;

public class Ternary {
    
    public static void main(String[] args) {
        
        // operator ternary = operator yang sama seperti if else namun lebih sederhana
        
        Scanner input = new Scanner(System.in);
        
        int age;
        String ucapan;
        
        System.out.print("enter your age ");
        
        age = input.nextInt();
        
        //        kondisi  ?      true              false
        ucapan = age <= 40 ? "Kamu masih muda" : "Kamu tua";
        
        System.out.println(ucapan);
    }
}
