package java.code;

public class ForLoop {
    
    public static void main(String[] args) {
        
        // For Loop = perulangan yang 
        
        // for(inisialisasi; kondisi; expresi) {
        //     statment
        // }
        
        // jika inisialisasi, kondisi, expresi tidak di isi maka perulangan tidak akan berhenti
        
        // For Loop tanpa henti
        // for(;;) {
        //     System.out.println("Perulangan tanpa henti");
        // }
        
        int day = 1;
        for(;day <= 7;) {
            System.out.printf("Days %d\n", day);
            day++;
        }
        
        System.out.println();
        
        for(int month = 1; month <= 12;) {
            System.out.printf("Month %d\n", month);
            month++;
        }
        
        System.out.println();
        
        for(int years = 22; years >= 0; years--) {
            System.out.println("Years " + years);
        }
        
        System.out.println();
        
        // contoh lop dalam lop
        for(int lop1 = 1; lop1 <= 10; lop1++) {
            for(int lop2 = 1; lop2 <= lop1; lop2++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}
