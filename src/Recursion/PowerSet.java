package Recursion;

import java.util.ArrayList;

public class PowerSet {
    static void main(String[] args) {
        String s = "abc";
        ArrayList<String> list = new ArrayList<>();
        subsets("", s, 0, list);
        System.out.println(list);
    }

    private static void subsets(String ans, String s, int idx, ArrayList<String> list) {
        if (idx == s.length()) {
            if (ans.length() != 0)
                list.add(ans);
            return;
        }
        char ch = s.charAt(idx);
        subsets(ans + ch, s, idx + 1, list);  // pick
        subsets(ans, s, idx + 1, list); // skip
    }
}
