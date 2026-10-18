package Recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParenthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Parentheses: ");
        int n = sc.nextInt();

        List<String> ans = generateParenthesis(n);

        System.out.println(ans);
    }

    public static void generate(int n, int l, int r, String s, List<String> ans) {

        // String has reached length n
        if (s.length() == n) {
            ans.add(s);
            return;
        }

        // Add '(' only up to n/2 opening brackets
        if (l < n / 2) {
            generate(n, l + 1, r, s + "(", ans);
        }

        // Add ')' only if there is an unmatched '('
        if (r < l) {
            generate(n, l, r + 1, s + ")", ans);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        // Odd length cannot have balanced parentheses
        if (n % 2 != 0) {
            return ans;
        }

        generate(n, 0, 0, "", ans);

        return ans;
    }
}