package Maps_And_Sets;

import java.util.HashSet;

public class PairsWithDiffK {
    static int countPairs(int[] arr, int k) {
        if(k < 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int ele : arr){
            if(set.contains(ele - k)){
                result.add(ele - k);
            }
            if(set.contains(ele + k)){
                result.add(ele);
            }
            set.add(ele);
        }
        return result.size();
    }
}
