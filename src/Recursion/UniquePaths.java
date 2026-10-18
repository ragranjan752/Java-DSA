package Recursion;

import java.util.Scanner;

public class UniquePaths {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st Number : ");
        int m = sc.nextInt();
        System.out.print("Enter 2nd Number : ");
        int n = sc.nextInt();
        System.out.println(uniquePath(m, n));
    }

    //    static int uniquePath(int m, int n) {
//        if (m == 1 || n == 1) return 1;
//        int ans = uniquePath(m - 1, n) + uniquePath(n - 1, m);
//        return ans;
//        }
    // method 2
    static int paths(int cr, int cc, int lr, int lc) {
        if (cr == lr && cc == lc) return 1;
        if (cr > lr || cc > lc) return 0; // important
        int right = paths(cr, cc + 1, lr, lc);
        int down = paths(cr + 1, cc, lr, lc);
        return right + down;
    }

    static int uniquePath(int m, int n) {
        return paths(0, 0, m - 1, n - 1);
    }

}
