package Recursion;

public class GlobalVariable {

    // It belongs to the class, so it can be accessed directly
    static int x = 10;

    public static void main(String[] args) {

        fun();

        // fun() changed the global x from 10 to 20.
        // Now x = 20.
        x = 9;

        // Prints the global x.
        // Output: 9
        System.out.println(x);

        // Creates a NEW local variable x inside main().
        // This local x is different from the global x.
        int x = 4;

        // Prints the local x.
        System.out.println(x);

        // Changes the LOCAL x from 4 to 6.
        // The global x is still 9.
        x = 6;
    }

    public static void fun() {

        // There is no local x inside fun(),
        // Changes global x:
        // 10 -> 20
        x = 20;
    }
}