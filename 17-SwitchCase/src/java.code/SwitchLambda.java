package java.code;

public class SwitchLambda {
    
    public static void main(String[] args) {
        
        // Switch Lambda (Java 14 keatas)
        
        String output;
        int nilaiMtk = 100;
        
        switch(nilaiMtk) {
            case 100 -> System.out.println("Anda Amazing");
            case 80 -> System.out.println("Anda Niat Sekolah");
            // atau bisa dengan block/body
            case 60 -> {
                System.out.println("Anda Normal");
            }
        }
        
        // contoh lain 
        int nilaiFisika = 90;
        String output2;
        
        switch(nilaiFisika) {
            case 100 -> output2 = "Anda Luar Biasa";
            case 90, 80 -> output2 = "Nilai anda bagus";
            case 70, 60 -> output2 = "Jangan lupa belajar";
            default -> output2 = "Hadehhhh";
        }
        
        System.out.println(output2);
        
        // contoh switch lambda dengan "yield"
        int nilaiIpa = 60;
        String ucapan;
        
        ucapan = switch(nilaiIpa) {
            case 100:
                yield "Anda Luar Biasa";
            case 90:
            case 80:
                yield "Nilai anda bagus";
            case 70:
            case 60:
                yield "Jangan lupa belajar";
            default:
                yield "Hadehhhh";
        };
        
        System.out.println(ucapan);
        
    }
}