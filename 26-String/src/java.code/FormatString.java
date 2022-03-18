package java.code;

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
        String nama2 = "jamet";
        int umur2 = 21;
        // %1(mengambil argumen index ke 1)$s
        System.out.printf("nama %1$s, %1$s berumur %2$d\n", nama2, umur2);
        
        // [flags]
        
        
        // [width]
        
        // [.precicion]
        
        
    }
}