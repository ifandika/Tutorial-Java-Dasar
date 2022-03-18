package java.code;

public class Faktorial {
    
    public static void main(String[] aegs) {
        
        // faktorial = nilai * nilai-1
        // n! => 5! = 5 * 4 * 3 * 2 * 1 = 120
        
        int nilai = 5;
        
        System.out.println(faktorial(nilai));
        
    }
    
    static int faktorial(int data) {
        if(data <= 1) {
            return data;
        }
        else {
            int hasil = 1;
            for(int index = data; index >= 1; index--) {
                hasil *= index;
            }
            return hasil;
        }
    }
}
