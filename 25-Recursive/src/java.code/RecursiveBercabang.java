package java.code;

import java.util.Scanner;

public class RecursiveBercabang {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("masukan nilai fibo ");
        int nilai = input.nextInt();
        
        recurFibonacci(nilai);
        
    }
    
    private static int recurFibonacci(int nilai) {
        if(nilai <= 1) {
            System.out.printf("fibo ke - %d\n", nilai);
            return nilai;
        }
        else {
            System.out.printf("fibo ke - %d\n", nilai);
            return recurFibonacci(nilai - 1) + recurFibonacci(nilai - 2);
        }
    }
}