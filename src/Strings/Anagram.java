package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter anagram : ");
        String s = sc.nextLine();
        System.out.print("Enter anagram : ");
        String s2 = sc.nextLine();

        // Anagram ke liye dono Strings ki length same honi chahiye
        if (s.length() != s2.length()) {
            System.out.println("false");
            return;
        }

        // String ko character array mein convert kar rahe hain
        char[] arr = s.toCharArray();
        char[] arr2 = s2.toCharArray();

        // Characters ko sort kar rahe hain
        Arrays.sort(arr);
        Arrays.sort(arr2);

        // Sorted arrays ke contents compare kar rahe hain
        if (Arrays.equals(arr, arr2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}