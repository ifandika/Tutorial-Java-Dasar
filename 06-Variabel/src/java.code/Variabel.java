package java.code;

public class Variabel {
    
    public static void main(String[] args) {
        
        // variabel = tempat menyimpan data, data bisa berubah ubah
        
        // inisialisasi variabel
        int variabel_1 = 100; // deklarasi variabel dan langsung memberikan nilai
        
        System.out.println("nilai variabel 1 = " + variabel_1);
        
        // merubah data/nilai variabel_1
        variabel_1 = 50;
        
        System.out.println("nilai baru variabel 1 = " + variabel_1);
        
        // hanya deklarasi variabel saja
        int variabel_2;
        variabel_2 = 200;
        
        System.out.println("nilai variabel 2 = " + variabel_2);
        
        // kata kunci var, finally
        // var = sebuah keyword untuk variabel bertipe apapun, namun harus langsung di assign
        // finally = keyowrd mirip const/konstanta pada bahasa p lain, yaitu sebuah variabel konstan yang tidak dapat diubah
        
        // java 10
        // var num; -> eror
        // num = 10;
        var varOtomatis = "ini keyword var"
        
        System.out.println(varOtomatis);
        
        finally int varFinally = 100;
        // varFinally = 200; -> error
        
        System.out.println(varFinally);
        
    }
}