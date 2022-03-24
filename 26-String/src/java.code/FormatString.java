package java.code;

import java.util.Formatter;
import java.lang.StringBuilder;

public class FormatString {
    
    public static void main(String[] args) {
        
        // format pada string
        // printf = print format
        
        String nama = "jupri";
        
        System.out.println("nama saya " + nama);
        
        // Struktur format = %[Argument_index$] [flags] [width] [.precicion]
        // %d decimal -> integer, short, long, byte
        // %f floating point -> float, double
        // %s string -> String
        // %b boolean -> boolean
        
        // printf tanpa Struktur
        String nama1 = "kipli";
        int umur1 = 19;
        
        System.out.printf("nama saya %s, %s berumur %d\n", nama1, nama1, umur1);
        
        // [Argument_index$]
        System.out.println("\n[Argument_index$]");
        String nama2 = "jamet";
        int umur2 = 21;
        // %1(mengambil argumen index ke 1)$s
        System.out.printf("nama %1$s, %1$s berumur %2$d\n", nama2, umur2);
        
        // [flags] -> untuk 
        System.out.println("\n[flags]");
        int nilai1 = 3;
        int nilai2 = 5;
        int hasil = nilai1 - nilai2;
        
        System.out.printf("%d - %d = %d\n", nilai1, nilai2, hasil);
        
        // [width]
        System.out.println("\n[width]");
        /* Decimal */
        int nilai3 = 1000;
        
        System.out.printf("%d", nilai3);
        System.out.printf("\n%6d", nilai3); // akan memberika space 5
        System.out.printf("\n%+6d", nilai3); // rata kanan
        System.out.printf("\n%-6d", nilai3); // rata kiri
        System.out.printf("\n%+-6d\n", nilai3); // mengabungkan
        /* Floating Point */
        double nilaiDo1 = 1.7589d;
        System.out.printf("%f\n", nilaiDo1);
        System.out.printf("%4f\n", nilaiDo1); // tidak akan berpengaruh
        System.out.printf("%8f\n", nilaiDo1); // akan berpengaruh
        System.out.printf("%+7f\n", nilaiDo1);
        
        // [.precision]
        System.out.println("\n[.precision]");
        float nilaiFlo1 = 5.67891f;
        
        System.out.printf("%f\n", nilaiFlo1);
        System.out.printf("%.1f\n", nilaiFlo1); // nilai setelah . hanya ada 1
        System.out.printf("%.3f\n", nilaiFlo1);
        System.out.printf("%7.2f\n", nilaiFlo1); // gabungan dengan width
        System.out.printf("%+07.1f\n", nilaiFlo1); // menambahkan 0 di depan
        
        // contoh 
        String namaS = "Kipli";
        double nilaiUjian = 8.960347758d;
        
        System.out.printf("\nnama siswa %1$s\n%1$s nilai ujian = %2$+.2f\n", namaS, nilaiUjian);
        
        // dengan method formater()
        
        String dataFormat = String.format("nama siswa %1$s\n%1$s nilai ujian = %2$+.2f\n", namaS, nilaiUjian);
        System.out.println(dataFormat);
        
        // save ke dalam StringBuilder
        StringBuilder strBuild = new StringBuilder();
        Formatter formatBuild = new Formatter(strBuild);
        
        // setiap kita memasukan data ke Formatter maka akan ke save ke StringBuilder
        formatBuild.format("nama siswa %1$s\n%1$s hasil nilai ujian = %2$+.2f\n", namaS, nilaiUjian);
        
        
        System.out.println(strBuild);
    }
}