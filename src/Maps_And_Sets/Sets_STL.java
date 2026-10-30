package Maps_And_Sets;

import java.util.HashSet;

public class Sets_STL {
    static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(77); set.add(65); set.add(21); set.add(2);
        set.add(11); set.add(45); set.add(3); set.add(77);
        System.out.println(set.size());
        System.out.println(set);
        System.out.println(set.contains(21)+" "+set.contains(25));
        set.remove(18);
        System.out.println(set.contains(18));
        System.out.println(set.size());
    }
}
