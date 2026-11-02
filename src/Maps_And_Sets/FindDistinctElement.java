package Maps_And_Sets;

import java.util.HashSet;

public class FindDistinctElement {
    public int countDistinct(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr)
            set.add(ele);
        return set.size();
    }
}
