package Recursion;

import java.util.Scanner;

public class LookAndSayPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LookAndSayPattern obj = new LookAndSayPattern();

        System.out.println(obj.CountAndSay(n));
    }

    public String CountAndSay(int n) {

        if (n == 1)
            return "1";

        String s = CountAndSay(n - 1);

        String ans = "";

        int i = 0;
        int j = 0;

        while (j < s.length()) {

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            else {
                int freq = j - i;

                ans += freq;
                ans += s.charAt(i);

                i = j;
            }
        }

        int freq = j - i;

        ans += freq;
        ans += s.charAt(i);

        return ans;
    }
}