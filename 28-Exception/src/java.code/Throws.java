package java.java.code;

import java.util.Scanner;

public class Throws {
    
    public static void main(String[] args) {
        
        // throws -> Contoh keyword Exception
        
        int[] numRay = {0,1,2,3};
        Scanner usrInput = new Scanner(System.in);
        
        System.out.print("data array ke- ");
        int nilai = usrInput.nextInt();
        
        // menggunakan try, catch
        try {
            System.out.printf("data array ke-%d -> %d\n", nilai, numRay[nilai]);
            
        }catch(Exception e) {
            System.out.println(e);
        }
        
    }
}