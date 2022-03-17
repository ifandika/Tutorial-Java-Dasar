package java.code;

public class MethodOverloading {
    
    public static void main(String[] args) {
        
        // overloading = menimpa
        // method overloading = suatu method yang memiliki nama sama dengan parameter berbeda
        
        printData(12.90d);
        printData("Kipli Forever");
        printData(10000);
    }
    
    static void printData(String data) {
        
        System.out.println(data);
    }
    
    static void printData(int data) {
      
        System.out.println(data);
    }
    
    static void printData(double data) {
        
        System.out.println(data);
    }
}
