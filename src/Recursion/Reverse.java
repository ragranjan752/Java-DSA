package Recursion;

public class Reverse {
    public static int reverse(int n, int r){
        if (n == 0){ // base call
            return r;
        }
        return reverse(n/10,r*10+n%10); // work
    }
    static void main(String[] args) {
        int n = 10;
        System.out.println( reverse(n, 0));
    }
}
