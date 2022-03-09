package com.tutorial;

public class Konversi {
    
    public static void main(String[] args) {
        
        int varInt = 100;
        
        System.out.println("varInt = " + varInt);
        
        // Konversi ke tipe data/rentang data yang lebih besar 
        long varLong = varInt;
        
        System.out.println("varLong = " + varLong);
        
        short varShort = 300;
        
        // Konversi ke tipe data/rentang data yang lebih kecil
        // ketika konversi ke yang lebih kecil maka data yang akan di konversi harus di casting
        byte varByte = (byte)varShort;
        
        System.out.println("varByte = " + varByte);
        
        /* casting operator */
        // merubah suatu tipe data ke tipe data lain
        
        int pembagi = 10;
        int dibagi = 4;
        
        // jika salah satu bilangan pecahan maka hasil berupa bilangan pecahan
        float hasil = (float)pembagi / dibagi;
        
        // % = untuk memasukan 
        // %d = desimal
        // %f = float
        
        System.out.printf("%d / %d = %f\n", pembagi, dibagi, hasil);
        
        short val_1 = 20;
        float val_2 = 3f;
        
        float result = val_1 / val_2;
        
        System.out.printf("%d / %f = %f\n", val_1, val_2, result);
        
    }
}