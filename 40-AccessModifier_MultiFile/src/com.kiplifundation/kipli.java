package com.kiplifundation;

public class Kipli {
    
    // bisa diakses oleh siapapun
    public static void kipliPublic() {
        System.out.println("Kipli: method public");
    }
    
    // hanya bisa diakses di dalam class Kipli
    private static void kipliPrivate() {
        System.out.println("Kipli: method private");
    }
    
    // hanya bisa diakses dalam package yang sama
    static void kipliDefault() {
        System.out.println("Kipli: method default");
    }
    
    // hanya bisa diakses dalam package yang sama
    protected static void kipliProtected() {
        System.out.println("Kipli: method protected");
    }
    
    public static void kipliSemuaMethod() {
        kipliPublic();
        kipliPrivate();
        kipliDefault();
        kipliProtected();
    }
}