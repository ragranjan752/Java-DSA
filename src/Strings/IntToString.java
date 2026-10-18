package Strings;

import java.util.Scanner;

public class IntToString {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = ""; // empty String
        //s += n;
        String a = Integer.toString(n);
        System.out.println(a);
        System.out.println(s);
    }
}
