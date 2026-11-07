package Maps_And_Sets;

import java.util.HashSet;

public class Sets_STL {
    static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(77); set.add(65); set.add(21); set.add(2);
        set.add(11); set.add(45); set.add(3); set.add(77); //duplicate element

        for (int ele : set){
            ele *= 2;
            System.out.print(ele+" ");
        }
        System.out.println();
//        for (int ele : set){  // error
//           set.remove(ele);
//           set.add(ele*2);
//        }

        set.clear();
        System.out.println();
        for (int ele : set){
            System.out.print(ele+" ");
        }

//        System.out.println(set.contains(21)+" "+set.contains(18));
//        set.remove(21);
//        System.out.println(set.contains(21));
//        System.out.println(set.size());
    }
}
