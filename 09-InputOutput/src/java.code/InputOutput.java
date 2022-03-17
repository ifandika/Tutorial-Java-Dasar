package java.code;

// import library/packages untuk input
import java.util.Scanner;

public class InputOutput {
    
    public static void main(String[] args) {
        
        // output
        
        // print
        System.out.print("print");
        // print line
        System.out.println("println");
        // print format
        System.out.printf("printf\n"); // \n new line
        
        // membuat object untuk input
        Scanner input = new Scanner(System.in);
        
        // input byte
        byte valByte;
        
        System.out.print("input byte : ");
        valByte = input.nextByte();
        System.out.println(valByte);
        
        // input short
        short valShort;
        
        System.out.print("input short : ");
        valShort = input.nextShort();
        System.out.println(valShort);
        
        // input integer
        int valInt;
        
        System.out.print("input int : ");
        valInt = input.nextInt(); // .nextInt();
        System.out.println(valInt);
        
        // input long
        long valLong;
        
        System.out.print("input long : ");
        valLong = input.nextLong();
        System.out.println(valLong);
        
        // input float
        float valFloat;
        
        System.out.print("input float : ");
        valFloat = input.nextFloat();
        System.out.println(valFloat);
        
        // input double
        double valDouble;
        
        System.out.print("input double : ");
        valDouble = input.nextDouble();
        System.out.println(valDouble);
        
        // input char
        char valChar;
        // tidak ada .nextChar(); -> kita bisa mengakalinya dengan .next().charAt(0);
        System.out.print("input char : ");
        valChar = input.next().charAt(0);
        System.out.println(valChar);
        
        // input String
        String valString;
        
        System.out.print("input string : ");
        valString = input.nextLine(); // bisa juga .next() namum jika ada space maka error
        System.out.println(valString);
        
    }
}