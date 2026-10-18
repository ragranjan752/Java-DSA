package Recursion;

import java.util.Scanner;

public class TowerOfHonoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. of Disk : ");
        int n = sc.nextInt();
        int move = hanoi(n,'A','B','C');
        System.out.print("Total No. of Move: "+ move);
    }
    private static int hanoi(int n, char src, char helper, char dest){
        if (n == 0) return n;
        // n - 1 disk from A to B via C
        int leftMove = hanoi(n-1,src,dest,helper);
        // largest from A to C
        System.out.println(src+" -> "+dest);
        // n - 1 disks from B to C via A
        int rightMove = hanoi(n-1,helper,src,dest);
        return leftMove + 1 + rightMove;
    }
}
