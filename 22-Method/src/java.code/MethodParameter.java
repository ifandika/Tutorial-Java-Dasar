package java.code;

public class MethodParameter {
    
    public static void main(String[] args) {
        
        // method dengan paramater
        // parameter pada method tidak ada batas nya
        String name = "Kipli Fundation";
        
        printName(name);
    }
    
    static void printName(String name) {
        
        System.out.printf("Your name %s", name);
    }
}
