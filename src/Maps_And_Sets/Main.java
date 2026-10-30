package Maps_And_Sets;

import java.util.HashSet;

public class Main {
    static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(77);
        set.add(65);
        set.add(21);
        set.add(2);
        set.add(11);
        set.add(45);
        set.add(3);
        set.add(77);
        // Convert HashSet into int array
        int[] arr = new int[set.size()];

        int i = 0;
        for (int ele : set) {
            arr[i++] = ele;
        }

        // Call TwoSum class method
        TwoSum obj = new TwoSum();

        System.out.println(obj.twoSum(arr, 80));

        // Missing Range
        MissingRange obj2 = new MissingRange();

        int[] nums = {1, 3, 5, 7};

        System.out.println(obj2.missingRange(nums, 1, 10));

        FindMissingElement obj3 = new FindMissingElement();

        System.out.println(obj3.missingNumber(nums));
    }
}
