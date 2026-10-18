package Strings;

public class BuiltInMethods {

    public static void main(String[] args) {

        String s = "Rag Ranjan";

        // indexOf() returns the index of the FIRST occurrence of 'a'
        System.out.println(s.indexOf('a'));       // 1


        // lastIndexOf() returns the index of the LAST occurrence of 'a'
        System.out.println(s.lastIndexOf('a'));  // 8


        // toLowerCase() converts the String to lowercase
        System.out.println(s.toLowerCase());     // rag ranjan


        // toUpperCase() converts the String to uppercase
        System.out.println(s.toUpperCase());     // RAG RANJAN


        String r = "harshita";

        // contains() checks whether the String contains
        // the given sequence of characters
        // Returns true or false
        System.out.println(r.contains("harsh"));  // true


        // contains() returns true because "arsh" exists in "harshita"
        System.out.println("happy");


        // startsWith() checks whether the String starts
        // with the given characters
        System.out.println(r.startsWith("ha"));   // true

        String str = "7585894";
        int n = Integer.parseInt(str);
        System.out.println(n+1);
    }
}