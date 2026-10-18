package Recursion;

import java.util.Scanner;

public class FactorialOfNumber {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        int result = fact(n);
        System.out.print("Factorial of "+n+": "+result);
    }

    static int fact(int n) {
        if (n == 0 || n == 1) return 1; // base case
        return n * fact(n - 1); // work and call
    }
}
