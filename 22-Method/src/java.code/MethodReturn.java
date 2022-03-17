package java.code;

public class MethodReturn {
    
    public static void main(String[] args) {
        
        // method tanpa return dan dengan return
        // jika membuat method tanpa return maka kita menggunakan tipe data pada method,
        // jika menggunakan void maka error karena void tidak bisa mengembalikan nilai
        
        short age = 70;
        
        tanpaReturn(age);
        
        System.out.println(denganReturn(age));
        
        
    }
    
    static void tanpaReturn(short age) {
        
        System.out.println("Your age " + age);
    }
    
    static short denganReturn(short age) {
        
        // akan mengembalikan nilai ke method
        return age;
    }
}
