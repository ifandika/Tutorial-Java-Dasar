package java.code;

public class OperatorBitwise {
    
    public static void main(String[] args) {
        
        // operator bitwise -> operasi untuk bit
        
        byte valA, valB, valC;
        String bitA, bitB, bitC;
        // merubah nilai menjadi satuan bit
        valA = 4;
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
        
        // bitwise SHL( Shift Left ) = <<
        System.out.println("\n================= SHL");
        valA = 2;
        // sebelum
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
        // sesudah
        valA = (byte)(valA << 2); // geser ke kiri 2
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
       
        // bitwise SHR( Shift Right ) = >>
        System.out.println("\n================= SHR");
        valB = 4;
        // sebelum
        bitB = String.format("%8s", Integer.toBinaryString(valB)).replace(' ', '0');
        System.out.printf("%d = %s\n", valB, bitB);
        // sesudah
        valB = (byte)(valB >> 2); // geser ke kanan 2
        bitB = String.format("%8s", Integer.toBinaryString(valB)).replace(' ', '0');
        System.out.printf("%d = %s\n", valB, bitB);
       
        // bitwise AND = &
        System.out.println("\n================= AND");
        valA = 3;
        valB = 5;
        valC = (byte)(valA & valB);
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        bitB = String.format("%8s", Integer.toBinaryString(valB)).replace(' ', '0');
        bitC = String.format("%8s", Integer.toBinaryString(valC)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
        System.out.printf("%d = %s\n", valB, bitB);
        System.out.println("---------------------");
        System.out.printf("%d = %s\n", valC, bitC);
        
        // bitwise OR = |
        System.out.println("\n================= OR");
        valA = 3;
        valB = 5;
        valC = (byte)(valA | valB);
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        bitB = String.format("%8s", Integer.toBinaryString(valB)).replace(' ', '0');
        bitC = String.format("%8s", Integer.toBinaryString(valC)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
        System.out.printf("%d = %s\n", valB, bitB);
        System.out.println("---------------------");
        System.out.printf("%d = %s\n", valC, bitC);
        
        // bitwise XOR = |
        System.out.println("\n================= XOR");
        valA = 3;
        valB = 5;
        valC = (byte)(valA ^ valB);
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        bitB = String.format("%8s", Integer.toBinaryString(valB)).replace(' ', '0');
        bitC = String.format("%8s", Integer.toBinaryString(valC)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
        System.out.printf("%d = %s\n", valB, bitB);
        System.out.println("---------------------");
        System.out.printf("%d = %s\n", valC, bitC);
        
        // bitwise NOT = ~
        System.out.println("\n================= NOT");
        // sebelum
        valA = 24;
        bitA = String.format("%8s", Integer.toBinaryString(valA)).replace(' ', '0');
        System.out.printf("%d = %s\n", valA, bitA);
        // sesudah
        valC = (byte)(~valA);
        bitC = String.format("%8s", Integer.toBinaryString(valC).substring(24));
        System.out.println("---------------------");
        System.out.printf("%d = %s\n", valC, bitC);
        
    }
}
