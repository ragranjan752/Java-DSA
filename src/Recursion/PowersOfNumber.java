package Recursion;

import java.util.Scanner;

public class PowersOfNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int n = sc.nextInt();

        int result = reverseExponentiation(n);

        System.out.println("Result = " + result);
    }

    static int reverseExponentiation(int n) {

        int rev = 0;
        int temp = n;

        // Find reverse of n
        while (temp > 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }

        // Calculate n^reverse(n)
        return power(n, rev);
    }

    static int power(int n, int rev) {

        // Base case
        if (rev == 0) {
            return 1;
        }

        // Recursive case
        return n * power(n, rev - 1);
    }
}