package java.code;

// library/packages String Builder
import java.lang.StringBuilder;

public class PengenalanStringBuilder {
    
    public static void main(String[] args) {
        
        // membuat object string Builder
        // kelebihan string builder = size/capacity bisa berkembang, address tetap walau data/value di modif
        StringBuilder strBuilder = new StringBuilder("saya kipli");
        
        printDataStrBuilder(strBuilder);
        
        // .append("kata")
        strBuilder.append(" dari Purworejo");
        printDataStrBuilder(strBuilder);
        
        // .insert(index, "kata")
        strBuilder.insert(16, "kota ");
        printDataStrBuilder(strBuilder);
        
        // .delete(indexAwal, indexAkhir);
        strBuilder.delete(16, 21);
        printDataStrBuilder(strBuilder);
        
        // .replace()
        strBuilder.replace(5, 10, "Jupri");
        printDataStrBuilder(strBuilder);
        
        // merubah StringBuilder ke String
        // jika merubah data String maka akan di buat String baru dan di masukan ke memory sehingga ada dua data String
        String strBiasa = strBuilder.toString();
        
        int addressStrBiasa = System.identityHashCode(strBiasa);
        
        System.out.println("\ndata -> " + strBiasa);
        System.out.println("jumlah kata -> " + strBiasa.length());
        System.out.println("address -> " + Integer.toHexString(addressStrBiasa));
        
    }
    
    private static void printDataStrBuilder(StringBuilder dataStrBuilder) {
        
        System.out.println("\ndata -> " + dataStrBuilder);
        System.out.println("jumlah kata -> " + dataStrBuilder.length());
        System.out.println("capasitas -> " + dataStrBuilder.capacity());
        int addressStrBuilder = System.identityHashCode(dataStrBuilder);
        
        System.out.println("address -> " + Integer.toHexString(addressStrBuilder));
    }
}