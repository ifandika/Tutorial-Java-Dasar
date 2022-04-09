package java.code;

// import file java yang berbeda package
import com.kiplifundation.Kipli;

public class Main {
    
    public static void main(String[] args) {
        
        /**
         * @Access Modifier
         * - public -> terbuka, bisa diakses siapapun
         * - private -> tertutup, hanya bisa diakses oleh class tersebut
         * - default -> bawaan, hanya bisa diakses dalam package yang sama
         * - protected -> terbatas, hanya bisa diakses dalam package yang sama. dan subclassnya 
         */
         
        // ( . ) untuk mengakses apapun dalam class
        
        // bisa karena public
        Mainan.methodPublic();
        
        // tidak bisa karena private
        // Mainan.methodPrivate();
        
        // bisa karena dalam package yang sama
        Mainan.methodDefault();
        
        // bisa karena dalam package yang sama
        Mainan.methodProtected();
        
        // mengakses methodPrivate lewat methodPublic
        Mainan.methodGabungan();
        
        // mengakses method pada com.kiplifundation.Kipli
        
        Kipli.kipliPublic(); // bisa karena public
        
        // Kipli.kipliPrivate(); // tidak bisa karena private
        
        // Kipli.kipliDefault(); // tidak bisa karena berbeda package
        
        // Kipli.kipliProtected(); // tidak bisa karena protected dan berbeda package
        
        Kipli.kipliSemuaMethod();
        
    }
}