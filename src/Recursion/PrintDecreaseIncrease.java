package Recursion;

import java.util.Scanner;

public class PrintDecreaseIncrease {
    static int n;

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        n = sc.nextInt();
        print(n);
    }

    public static void print(int n) {
        if (n == 0) return; // Base Case
        System.out.print(n + " ");
        print(n - 1);  // call
        if(n != 1){  // work
            System.out.print(n + " ");
        }
    }
}
