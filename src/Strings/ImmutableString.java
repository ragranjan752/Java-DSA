package Strings;

public class ImmutableString {
    static void main(String[] args) {
        String s = "Bihal";
        System.out.println(s);
        s = s.substring(0,2)+'m'+s.substring(3);
        System.out.println(s);
    }
}
