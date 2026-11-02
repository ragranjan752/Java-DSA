package Maps_And_Sets;

import java.util.TreeSet;
// Tree set is a ordered set
public class Tree_Sets {
    static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();  // balanced BST
        set.add(77); set.add(65); set.add(21); set.add(2);
        set.add(11); set.add(45); set.add(3); set.add(77); //duplicate element
        System.out.println(set.size());
        System.out.println(set);

        System.out.println(set.contains(21)+" "+set.contains(18));
        set.remove(21);
        System.out.println(set.contains(21));
        System.out.println(set.size());
    }
}
