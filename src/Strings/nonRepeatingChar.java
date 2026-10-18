package Strings;

import java.util.Scanner;

public class nonRepeatingChar {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lowercase words : ");
        String s = sc.nextLine();
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            count[index]++;
        }
        int highestCount = 0;
        char ans = s.charAt(0);
        for (int i = 0; i < 26; i++) {
            if (count[i] > highestCount) {
                highestCount = count[i];
                ans = (char) (i + 'a');
            }
        }
        System.out.println(ans + " is the character with the highest frequency: " + highestCount);
    }
}
