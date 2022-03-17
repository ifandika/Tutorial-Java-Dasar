package java.code;

public class Logika {
    
    public static void main(String[] args) {
        
        // operasi logika
        
        int a = 10;
        int b = 5;
        boolean hasil;
        
        // AND = &&
        
        System.out.println(">> AND = && <<");
        hasil = (a == 5 && b == 10);
        System.out.println("false && false = " + hasil);
        hasil = (a == 10 && b == 9);
        System.out.println("true && false  = " + hasil);
        hasil = (a == 3 && b == 5);
        System.out.println("false && true  = " + hasil);
        hasil = (a == 10 && b == 5);
        System.out.println("true && true   = " + hasil);
        
        
        // OR = ||
        
        System.out.println(">> OR = || <<");
        hasil = (a == 5 || b == 10);
        System.out.println("false && false = " + hasil);
        hasil = (a == 10 || b == 9);
        System.out.println("true && false  = " + hasil);
        hasil = (a == 3 || b == 5);
        System.out.println("false && true  = " + hasil);
        hasil = (a == 10 || b == 5);
        System.out.println("true && true   = " + hasil);
        
        
        // XOR = ^
        
        System.out.println(">> XOR = ^ <<");
        hasil = (a == 5 ^ b == 10);
        System.out.println("false && false = " + hasil);
        hasil = (a == 10 ^ b == 9);
        System.out.println("true && false  = " + hasil);
        hasil = (a == 3 ^ b == 5);
        System.out.println("false && true  = " + hasil);
        hasil = (a == 10 ^ b == 5);
        System.out.println("true && true   = " + hasil);
        
        // NOT = !
        
        System.out.println(">> NOT = ! <<");
        hasil = !(a == 10);
        System.out.println("true  = " + hasil);
        hasil = !(b == 9);
        System.out.println("false = " + hasil);
        
    }
}
