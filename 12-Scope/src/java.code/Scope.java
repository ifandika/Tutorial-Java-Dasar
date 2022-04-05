package java.code;

// global scope file

public class Scope {
    
    // global scope class
    int dataGlobal = 12345;
    
    public static void main(String[] args) {
        
        // scope / jangkuan sebuah data / variabel
        // - global scope
        // - local scope
        // - block scope
        
        // local scope yang hanya bisa di akses di dalam method main
        int nilaiInt = 12345;
        
        {
            // block scope, hanya bisa di akses di dalam block ini saja
            String name = "Kipli";
            
            System.out.println(name);
        }
        
        System.out.println(nilaiInt);
        
        // System.out.println(name); // error karena data berada pada block
        
        printHello();
        printWord();
    }
    
    static void printHello() {
        // ini scope local pada method
        String output = "Hello";
        System.out.print(output);
    }
    
    static void printWord() {
        // ini scope local pada method
        String output = " Word";
        System.out.println(output);
    }
}
