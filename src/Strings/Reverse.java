package Strings;

public class Reverse {
    static void main(String[] args) {
//        String s = "Devesh";
//        StringBuilder sb = new StringBuilder(s);
//        sb.append("jain");
//        System.out.println(sb);

        String s = "Devesh";
        StringBuilder sb = new StringBuilder(s);
//        //sb.reverse();
        int i = 0, j = sb.length() - 1;
        while (i <= j) {
            char temp = sb.charAt(i);
            char temp2 = sb.charAt(j);
            sb.setCharAt(i, temp2);
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        System.out.println(sb);
//        String s = "Aditya";
//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        s = sb.toString();
//        System.out.println(s);
    }
}
