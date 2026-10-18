package Strings;

import java.util.ArrayList;

public class StringBuilders { // string builder is a mutable
    static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("Rag ");
//        System.out.println(sb.length()+" "+sb.capacity());
//        sb.append("Ranjan is a good boy");
//        System.out.println(sb);
//        System.out.println(sb.length()+" "+sb.capacity()); // new capacity = old capacity × 2 + 2 = 42
//        System.out.println();

        StringBuilder s = new StringBuilder(6);
        System.out.println(s.length()+" "+s.capacity());
        s.append("RagRanjan");
        System.out.println(s.length()+" "+s.capacity());
        System.out.println(s);
        s.setCharAt(1,'o');
        System.out.println(s);
        String t = s.toString();
        System.out.println(t);
    }
}
