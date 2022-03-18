package java.code;

public class DoWhile {
    
    public static void main(String[] args) {
      
        // do while = perulangan yang memungkinkan melakukan satu statment walau kondisi false
        
        short month = 1;
        
        do {
            
            System.out.println("Month " + month);
            
            month++;
        }while(month >= 12);
        
        System.out.println();
        
        month = 1;
        
        do {
            
            System.out.println("Month " + month);
            
            month++;
        }while(month <= 12);
        
    }
}