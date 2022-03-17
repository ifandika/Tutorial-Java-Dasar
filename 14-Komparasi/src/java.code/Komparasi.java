package java.code;

public class OperatorKomparasi {
    
    public static void main(String[] args) {
        
        // operator komparasi
        
        int var1 = 10;
        int var2 = 12;
        
        // == (sama dengan)
        System.out.println("( == )");
        System.out.printf("%d == %d -> %s\n", var1, var2, (var1 == var2));
        var1 = 10;
        var2 = 10;
        System.out.printf("%d == %d -> %s\n", var1, var2, (var1 == var2));
        
        // < (kurang dari)
        System.out.println("( < )");
        var1 = 10;
        var2 = 12;
        System.out.printf("%d < %d -> %s\n", var1, var2, (var1 < var2));
        var1 = 10;
        var2 = 10;
        System.out.printf("%d < %d -> %s\n", var1, var2, (var1 < var2));
        
        // > (lebih dari)
        System.out.println("( > )");
        var1 = 12;
        var2 = 10;
        System.out.printf("%d > %d -> %s\n", var1, var2, (var1 > var2));
        var1 = 10;
        var2 = 10;
        System.out.printf("%d > %d -> %s\n", var1, var2, (var1 > var2));
        
        // <= (kurang dari sama dengan)
        System.out.println("( <= )");
        var1 = 12;
        var2 = 10;
        System.out.printf("%d <= %d -> %s\n", var1, var2, (var1 <= var2));
        var1 = 10;
        var2 = 10;
        System.out.printf("%d <= %d -> %s\n", var1, var2, (var1 <= var2));
        
        // >= (lebih dari sama dengan)
        System.out.println("( >= )");
        var1 = 10;
        var2 = 12;
        System.out.printf("%d >= %d -> %s\n", var1, var2, (var1 >= var2));
        var1 = 10;
        var2 = 10;
        System.out.printf("%d >= %d -> %s\n", var1, var2, (var1 >= var2));
        
        // != tidak sama dengan
        System.out.println("( != )");
        var1 = 10;
        var2 = 12;
        System.out.printf("%d != %d -> %s\n", var1, var2, (var1 != var2));
        var1 = 10;
        var2 = 10;
        System.out.printf("%d != %d -> %s\n", var1, var2, (var1 != var2));
        
    }
}
