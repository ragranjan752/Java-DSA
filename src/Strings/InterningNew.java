package Strings;

public class InterningNew {
    static void main(String[] args) {
        // String literal
        // "Rag" String Pool mein store hota hai
        String a = "Rag";

        // Same String literal
        // Java existing "Rag" ko String Pool se use karega
        String b = "Rag";

        // new keyword use karne par
        // Heap memory mein ek NEW String object create hota hai
        String c = new String("Rag");


        // == references/addresses compare karta hai
        System.out.println(a == b);  // true

        // a aur c ka content same hai,
        // lekin dono different objects ko refer kar rahe hain
        System.out.println(a == c);  // false


        // equals() actual String content compare karta hai
        System.out.println(a.equals(c));  // true
    }
}
