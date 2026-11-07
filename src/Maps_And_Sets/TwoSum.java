package Maps_And_Sets;

import java.util.HashSet;

public class TwoSum {
    public static boolean twoSum(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        int rem = 0;
        for(int ele : arr){
            rem = target - ele;
            if(set.contains(rem)) return true;
            set.add(ele);
        }
        return false;
    }
}
