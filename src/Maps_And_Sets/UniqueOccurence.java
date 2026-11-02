package Maps_And_Sets;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurence {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int freq : map.values()) {
            if (!set.add(freq)) {
                return false;
            }
        }

        return true;
    }
}
