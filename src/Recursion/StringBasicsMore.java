package Recursion;

import java.util.ArrayList;

public class StringBasicsMore {
    static void main(String[] args) {
        String s = "RagRanjan";
        change(s);
        System.out.println(s);

//        String[] arr = {"Santosh","krish","hemant","vivek",};
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i]+" ");
//        }

        ArrayList<String> al = new ArrayList<>();
        al.add("ranjan");
        al.add("shravari");
        al.add("umang");
        al.add("ayan");
        al.add("shelly");
        al.add("Riya");
        System.out.println(al);
        change2(al);
        System.out.println(al);
    }
    private static void change2(ArrayList<String> al){
        al.add("rag");
    }

    private static void change(String s) {
        s = "lavish";
    }
}
