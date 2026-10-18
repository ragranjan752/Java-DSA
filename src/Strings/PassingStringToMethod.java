package Strings;

public class PassingStringToMethod {

    // This method receives a copy of the String reference
    public static void change(String x) {
        // x now points to a new String object
        // It does NOT change the original String in main()
        x = "ranjan";
    }

    // Program execution starts here
    public static void main(String[] args) {

        // Original String
        String x = "rag";

        // Prints: rag
        System.out.println(x);

        // Pass x to the method
        change(x);

        // Still prints: rag
        // The original String variable was not changed
        System.out.println(x);
    }
}