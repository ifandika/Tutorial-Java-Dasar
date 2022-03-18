package java.code;

public class ForEach {
    
    public static void main(String[] args) {
        
        // for each = for untuk mengambil data array
        
        String[] artis = {"Ucup", "Kipli", "Jupri", "Jamet", "Kudasi"};
        
        // mengambil data array tanpa for each
        // method untuk mengetahui panjang data array = .length
        
        for(short index = 0; index < artis.length; index++) {
            
            System.out.println(artis[index]);
        }
        
        System.out.println();
        // mengambil data array dengan for each
        
        for(String data : artis) {
            
            System.out.println(data);
            
        }
        
    }
}
