package java.code;

import java.util.Scanner;

public class CreatePattern {
    
    public static void main(String[] args) {
        
        // membuat pola dengan loop
        
        Scanner input = new Scanner(System.in);
        short nilai;
        
        System.out.print("masukan nilai pola : ");
        nilai = input.nextShort();
        
        System.out.println("pattern 1\n");
        for(short lop1 = 0; lop1 < nilai; lop1++) {
            for(short lop2 = 0; lop2 < nilai; lop2++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println("\npattern 2\n");
        // r = if (nilai_lopPertama == nilai_lopKedua) -> break
        for(short lop1 = 0; lop1 < nilai; lop1++) {
            for(short lop2 = 0;lop2 < nilai; lop2++) {
                System.out.print("*");
                if(lop1 == lop2) {
                    break;
                }
            }
            System.out.println();
        }
        
        System.out.println("\npattern 3\n");
        // contoh: n = 5 -> batas loop
        // r = if ((nilai_lopPertama + nilai_lopKedua) == (batasLop - 1))
        for(short lop1 = 0; lop1 < nilai; lop1++) {
            for(short lop2 = 0; lop2 < nilai; lop2++) {
                System.out.print("*");
                if((lop1 + lop2) == (nilai - 1)){
                    break;
                }
            }
            System.out.println();
        }
        
        System.out.println("\npattern 4\n");
        // r = r(pattern 2) dan r(pattern 3)
        for(short lop1 = 0; lop1 < nilai; lop1++) {
            for(short lop2 = 0; lop2 < nilai; lop2++) {
                System.out.print("*");
                if(lop1 == lop2) {
                    break;
                }
                else if((lop1 + lop2) == (nilai - 1)) {
                    break;
                }
            }
            System.out.println();
        }
        
    }
}