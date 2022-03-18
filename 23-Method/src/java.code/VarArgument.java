package java.code;

public class VarArgument {
    
    public static void main(String[] args) {
        
        // variabel argument = memasukan data seperti array pada parameter method
        
        int[] nilaiTest = {80, 30, 50, 90};
        bukanVarArgument("Jupri", nilaiTest);
        
        // jika menggunakan variabel parameter maka kita bisa langsung memasukan nilai array pada argument
        denganVarArgument("Kipli", 90, 100, 75, 80);
        
    }
    
    static void bukanVarArgument(String name, int[] nilai) {
        int total = 0;
        
        for(int nilaiPerIndex : nilai) {
            total += nilaiPerIndex;
        }
       
        int hasil = total / nilai.length;
      
        String ucapan = hasil >= 75 ? "Selamat " + name + ", Anda Lulus" : "Maaf " + name + ", Coba Lagi";
        
        System.out.println(ucapan);
    }
    
    static void denganVarArgument(String name, int... nilai) {
        int total = 0;
        
        for(int nilaiPerIndex : nilai) {
            total += nilaiPerIndex;
        }
        
        int hasil = total / nilai.length;
        
        String ucapan = hasil >= 75 ? "Selamat " + name + ", Anda Lulus" : "Maaf " + name + ", Coba Lagi";
        
        System.out.println(ucapan);
        
    }
}
