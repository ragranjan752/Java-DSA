package Recursion;

public class PreInPost {
    static void main(String[] args) {
        pip(5);
    }

    public static void pip(int n) {
        if (n == 0) return;  // base case
        System.out.println("pre" + n + " "); // pre  work
        pip(n - 1); // call
        System.out.println("In" + n + " "); // in  work
        pip(n - 1); // call
        System.out.println("post" + n + " "); // post  work
    }
}
