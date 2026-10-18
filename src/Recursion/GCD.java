package Recursion;

import java.util.Scanner;

public class GCD {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st Number : ");
        int a = sc.nextInt();
        System.out.print("Enter 2nd Number : ");
        int b = sc.nextInt();
        int result = gcd(a, b);
        System.out.println(result);
    }

    static int gcd(int a, int b) {
        return helper(Math.min(a, b), Math.max(a, b));
    }
    public static int helper(int a, int b) {
        if (a == 0) return b;
        return helper(b % a, a);
    }
}
