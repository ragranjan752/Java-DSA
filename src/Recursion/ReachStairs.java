package Recursion;

import java.util.Scanner;

public class ReachStairs {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n number : ");
        int n = sc.nextInt();
        System.out.print("Total Number of Ways "+stairs(n));
    }
    static int stairs(int n){
        if (n <= 2) return n;
        return stairs(n-1)+stairs(n-2);
    }
}
