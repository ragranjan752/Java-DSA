package Strings;

import java.util.Collections;

public class DeleteChar {
    static void main(String[] args) {
        String s = "Devesh";
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(1);
        System.out.println(sb);
        sb.insert(1,'e');
        System.out.println(sb);
        sb.delete(0,3);
        System.out.println(sb);
    }
}
