package java.code;

public class ControlFlow {
    
    public static void main(String[] args) {
        
        // control flow = sebuah keyword untuk melakukan suatu tindakan
        // Break = berhenti
        // Continue = lanjut
        
        short nilaiShort = 1;
        
        while(nilaiShort <= 50) {
            
            if(nilaiShort == 25) {
                System.out.println("Perulangan dihentikan");
                break;
            }
            
            System.out.println("nilai " + nilaiShort);
            
            nilaiShort++;
        }
        
        System.out.println();
        
        byte absen = 0;
        
        for(; absen < 10; absen++) {
            
            if(absen >= 6 && absen <= 8) {
                System.out.println("Absen ke " + absen + " : Tidak Absen");
                continue;
            }
            System.out.println("Absen ke " + absen + " : Absen");
        }
        
    }
}
