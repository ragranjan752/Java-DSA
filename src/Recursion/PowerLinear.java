package Recursion;

import java.util.Scanner;

public class PowerLinear {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base of Power : ");
        int a = sc.nextInt();
        System.out.print("Enter exponential of the base : ");
        int b = sc.nextInt();
        int result = power(a,b);
        System.out.println(a+" raise to the power "+b+" is "+result);
    }
    static int power(int a, int b){
        if( b == 0) return 1;
        int ans = power(a,b/2);
        if(b % 2 == 0) return ans*ans;
        else return a*ans*ans;
    }
    // brute force code
//    static int power(int a, int b){
//        if( b == 0) return 1;
//        return a*power(a,b-1);
//    }
}
