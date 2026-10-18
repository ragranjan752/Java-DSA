package Strings;

public class concatInString {
    static void main(String[] args) {
        String a = "Rag ";
        String b = "Ranjan";
        System.out.println(a.concat(b));
//        a = a.concat(b);
        a = a + b;
        System.out.println(a);
    }
}
