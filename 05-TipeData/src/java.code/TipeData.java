package java.code;

public class TipeData {
    
    public static void main(String[] args) {
        
        /* Tipe Data Primitive/Bawaan */
        // Tipe Data pada Java
        // integer, byte, long, short, double, float, char, boolean
        
        // bilangan bulat/decimal = byte, short, integer, long
        // bilangan pecahan = float, double
        // karakter = char
        // true/false = boolean
        
        int varInt = 100;
        System.out.println("=== integer ===");
        System.out.println("nilai     = " + varInt);
        System.out.println("Min Range = " + Integer.MIN_VALUE);
        System.out.println("Max Range = " + Integer.MAX_VALUE);
        System.out.println("size      = " + Integer.BYTES + " byte");
        System.out.println("size      = " + Integer.SIZE + " bit");
        
        byte varByte = 10;
        System.out.println("\n=== byte ===");
        System.out.println("nilai     = " + varByte);
        System.out.println("Min Range = " + Byte.MIN_VALUE);
        System.out.println("Max Range = " + Byte.MAX_VALUE);
        System.out.println("size      = " + Byte.BYTES + " byte");
        System.out.println("size      = " + Byte.SIZE + " bit");
        
        short varShort = 120;
        System.out.println("\n=== short ===");
        System.out.println("nilai     = " + varShort);
        System.out.println("Min Range = " + Short.MIN_VALUE);
        System.out.println("Max Range = " + Short.MAX_VALUE);
        System.out.println("size      = " + Short.BYTES + " byte");
        System.out.println("size      = " + Short.SIZE + " bit");
        
        long varLong = 1234567L;
        System.out.println("\n=== long ===");
        System.out.println("nilai     = " + varLong);
        System.out.println("Min Range = " + Long.MIN_VALUE);
        System.out.println("Max Range = " + Long.MAX_VALUE);
        System.out.println("size      = " + Long.BYTES + " byte");
        System.out.println("size      = " + Long.SIZE + " bit");
        
        float varFloat = 12.3f;
        System.out.println("\n=== float ===");
        System.out.println("nilai     = " + varFloat);
        System.out.println("Min Range = " + Float.MIN_VALUE);
        System.out.println("Max Range = " + Float.MAX_VALUE);
        System.out.println("size      = " + Float.BYTES + " byte");
        System.out.println("size      = " + Float.SIZE + " bit");
        
        double varDouble = 15.51d;
        System.out.println("\n=== double ===");
        System.out.println("nilai     = " + varDouble);
        System.out.println("Min Range = " + Double.MIN_VALUE);
        System.out.println("Max Range = " + Double.MAX_VALUE);
        System.out.println("size      = " + Double.BYTES + " byte");
        System.out.println("size      = " + Double.SIZE + " bit");
        
        char varChar = 'C';
        System.out.println("\n=== char ===");
        System.out.println("nilai     = " + varChar);
        System.out.println("Min Range = " + Character.MIN_VALUE);
        System.out.println("Max Range = " + Character.MAX_VALUE);
        System.out.println("size      = " + Character.BYTES + " byte");
        System.out.println("size      = " + Character.SIZE + " bit");
        
        boolean varBoolean = true;
        System.out.println("\n=== boolean ===");
        System.out.println("nilai     = " + varBoolean);
        System.out.println("Min Range = " + Boolean.FALSE);
        System.out.println("Max Range = " + Boolean.TRUE);
        // System.out.println("size      = " + Boolean.BYTES + " byte");
        // System.out.println("size      = " + Boolean.SIZE + " bit");
        
        int numDecimal = 35;
        int hexaDecimal = 0xFFFFF;
        int binaryDecimal = 0b01010110;
        
        System.out.println(numDecimal);
        System.out.println(hexaDecimal);
        System.out.println(binaryDecimal);
        
        // mengunakan underscore
        double harga = 1_000_000_000;
        
        System.out.println(harga);
        
        System.out.println("\n");
        /* Tipe Data Bukan Primitive/Object */
        // pada tipe data bukan primitive memiliki method karena ia adalah object
        // nilai default pada tipe data bukan primitive adalah null(kosong)
        
        Byte iniByte = 100;
        System.out.println(iniByte);
        
        Short iniShort = 1000;
        System.out.println(iniShort);
        
        Integer iniInteger = 10000;
        System.out.println(iniInteger);
        
        Long iniLong = 100000;
        System.out.println(iniLong);
        
        Float iniFloat = 1.123;
        System.out.println(iniFloat);
        
        Double iniDouble = 1.12345;
        System.out.println(iniDouble);
        
        Character iniCharacter = 'A';
        System.out.println(iniCharacter);
        
        Boolean iniBoolean = true;
        System.out.println(iniBoolean);
        
        String iniString = "kipli";
        System.out.println(iniString);
        
        // contoh nilai default
        Short nilaiDefault;
        System.out.println(nilaiDefault);
        
    }
}