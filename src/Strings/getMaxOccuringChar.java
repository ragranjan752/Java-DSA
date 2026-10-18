package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class getMaxOccuringChar {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lowercase words : ");
        String s = sc.nextLine();
//        int n = s.length();
//        int maxFreq = -1;
//        char ans = s.charAt(0);
//        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
//        int i = 0, j = 0;
//        while(j < n){
//            if (arr[i] == arr[j]) j++;
//            else{
//                int freq = j - i;
//                if(freq > maxFreq){
//                    maxFreq = freq;
//                    ans = arr[i];
//                }
//                i = j;
//            }
//        }
//        int freq = j - i;
//        if(freq > maxFreq){
//            maxFreq = freq;
//            ans = arr[i];
//        }

        // method 2 -> best solution ever
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            int idx = ch - 'a'; // ch - 97
            freq[idx]++;
        }
        int maxFreq = 0;
        char ans = s.charAt(0);
        for(int i = 0; i < 26; i++)
        {
            if(freq[i]>maxFreq){
                maxFreq = freq[i];
                ans = (char)(i + 97);
            }
        }
        System.out.print(ans + " is the character with the highest frequency: " + maxFreq);    }
}
