package Strings;

public class StringToCharArray {
    static void main(String[] args) {
        String s = "rag";
        char[] arr = s.toCharArray(); // camel case/pascal case
        for (char ch : arr) {
            System.out.print(ch);
        }
    }
}
