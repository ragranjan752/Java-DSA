package Recursion;

public class FirstOccurrenceOfElement {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 2, 4, 5};
        int target = 2;

        FirstOccurrenceOfElement obj = new FirstOccurrenceOfElement();

        int result = obj.search(nums, target);

        System.out.println("Index = " + result);
    }

    public int helper(int[] nums, int target, int lo, int hi) {

        // Target not found
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;

        // Target found
        if (nums[mid] == target) {
            // Check if this is the first occurrence
            int left = helper(nums, target, lo, mid - 1);

            // If target exists on the left, return that index
            if (left != -1) return left;

            // Otherwise current mid is the first occurrence
            return mid;
        }

        // Target is in the left half
        else if (nums[mid] > target) return helper(nums, target, lo, mid - 1);


            // Target is in the right half
        else return helper(nums, target, mid + 1, hi);
    }

    public int search(int[] nums, int target) {

        return helper(nums, target, 0, nums.length - 1);
    }
}