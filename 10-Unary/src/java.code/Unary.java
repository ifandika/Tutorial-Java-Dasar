package java.code;

public class Unary {
    
    public static void main(String[] args) {
        
        // operator unary = operator yang tidak merubah nilai
        
        // + (menjadi positif)
        // - (menjadi negatif)
        
        int ageUcup = 97;
        int ageKipli = 55;
        
        // before
        System.out.println("ageUcup " + +ageUcup);
        System.out.println("ageKipli " + -ageKipli);
        
        // after
        System.out.println("ageUcup " + ageUcup);
        System.out.println("ageKipli " + ageKipli);
        
        // operator increment dan decrement, operator yang dpt merubah nilai
        // prefix = ++data , --data
        // post   = data++ , data--
        
        int num1 = 5;
        int num2 = 5;
        
        // prefix
        System.out.println("prefix ++ = " + ++num1);
        System.out.println("prefix -- = " + --num2);
        
        num1 = 5;
        num1++;
        
        num2 = 5;
        num2--;
        
        // postfix
        System.out.println("postfix ++ = " + num1);
        System.out.println("postfix -- = " + num2);
        
        // operator boolean !
        boolean numBool1 = true;
        boolean numBool2 = false;
        
        System.out.println("numBool1 = " + !numBool1);
        System.out.println("numBool2 = " + !numBool2);
        
    }
}
