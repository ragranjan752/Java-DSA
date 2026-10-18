package Strings;

public class LogicOfCompare {
    public static int compare(String a, String b) {

        int n = Math.min(a.length(), b.length());

        for (int i = 0; i < n; i++) {

            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) - b.charAt(i);
            }
        }

        return a.length() - b.length();
    }

    static void main(String[] args) {
        String a = "rag";
        String b = "ranjan";
        System.out.println(a.compareTo(b));
    }
}
