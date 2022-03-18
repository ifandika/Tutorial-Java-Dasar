package java.code;

import java.util.Scanner;

public class IfElse {
    
    public static void main(String[] args) {
        
        // if else statment
        
        Scanner in = new Scanner(System.in);
        
        int age;
        
        System.out.print("enter your age : ");
        age = in.nextInt();
        
        // (kondisi)
        if(age > 30) {
            System.out.println("you old");
        }
        
        if(age < 20) {
            System.out.println("hey young man");
        }
        else if(age == 25) {
            System.out.println("your age 25");
        }
        else {
            System.out.printf("your age %d\n", age);
        }
        
        int testValue;
        
        testValue = 75;
        
        if(testValue >= 80)
            System.out.println("your good");
        else if(testValue == 75) System.out.println("nice");
        else 
            System.out.println("not today");
        
    }
}