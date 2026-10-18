package Recursion;

import java.util.Scanner;

public class printOnetoN {
    static int n;

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        n = sc.nextInt();
        // print(1, n);
        print(n);
    }
    public static void print(int n){
        if(n==0) return;  // Base Case
        print(n-1);  // call
        System.out.print(n+" "); // work
    }
//    public static void print(int x) {
//        if (x > n) return;
//        System.out.println(x);
//        print(x + 1);
//    }
//    public static void print(int x,int n) {
//        if (x > n) return;
//        System.out.println(x);
//        print(x + 1, n);
//    }
}
