package java.code;

class Mainan {
    
    // bisa diakses oleh file java lainnya
    public static void methodPublic() {
        System.out.println("Mainan: method public");
    }
    
    // hanya bisa diakses oleh class Mainan
    private static void methodPrivate() {
        System.out.println("Mainan: method private");
    }
    
    // jika default maka tidak usah ditulis
    // default static void methodDefault()
    // bisa diakses file java lain dalam package yang sama
    static void methodDefault() {
        System.out.println("Mainan: method default");
    }
    
    // bisa diakses oleh siapapun dalam package yang sama
    protected static void methodProtected() {
        System.out.println("Method: method protected");
    }
    
    public static void methodGabungan() {
        System.out.println("Mainan: method default");
        methodPrivate(); // bisa memgakses karena dalam satu class
    }
}