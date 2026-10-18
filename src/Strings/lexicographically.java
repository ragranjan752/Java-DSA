package Strings;

public class lexicographically {

    static void main(String[] args) {
        String a = "rag";
        String b = "ranjan";
        System.out.println(a.compareTo(b));  //'g' - 'n' = 103 - 110 = -7
        System.out.println("rag " + a.compareTo("ra"));
    }
}
