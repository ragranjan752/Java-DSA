package Strings;

import java.util.Scanner;

public class PrintVowels {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch =='a'|| ch =='e' || ch=='i' || ch=='o' || ch=='u'){
                System.out.print(ch+" ");
                count++;
            }
        }
        System.out.println();
        System.out.println("Total Vowel "+count);
    }
}
