package Maps_And_Sets;

import java.util.HashSet;

public class FindMissingElement {
    public int missingNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all elements in HashSet
        for (int ele : nums) {
            set.add(ele);
        }

        // Find the missing number
        for (int i = 0; i <= nums.length; i++) {

            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
