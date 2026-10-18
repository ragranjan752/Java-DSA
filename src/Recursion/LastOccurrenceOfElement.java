package Recursion;

public class LastOccurrenceOfElement {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 2, 4, 5};
        int target = 2;

        LastOccurrenceOfElement obj = new LastOccurrenceOfElement();

        int result = obj.search(nums, target);

        System.out.println("Index = " + result);
    }

    public int helper(int[] nums, int target, int lo, int hi) {

        // Base case
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        // Target found
        if (nums[mid] == target) {

            // Search for another occurrence on the right
            int right = helper(nums, target, mid + 1, hi);

            // If found on right, return that index
            if (right != -1) {
                return right;
            }

            // No target on right
            // So current mid is the last occurrence
            return mid;
        }

        // Target is in the left half
        else if (nums[mid] > target) {

            return helper(nums, target, lo, mid - 1);
        }

        // Target is in the right half
        else {

            return helper(nums, target, mid + 1, hi);
        }
    }

    public int search(int[] nums, int target) {

        return helper(nums, target, 0, nums.length - 1);
    }
}