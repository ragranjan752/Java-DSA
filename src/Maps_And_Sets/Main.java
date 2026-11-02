
package Maps_And_Sets;

public class Main {
    public static void main(String[] args) {

        // Count distinct elements
        FindDistinctElement obj = new FindDistinctElement();
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println(obj.countDistinct(arr));

        // Check unique occurrences
        System.out.println(UniqueOccurence.uniqueOccurrences(arr));

        // Two Sum
        System.out.println(TwoSum.twoSum(arr, 9));

        // Count pairs with difference K
        System.out.println(PairsWithDiffK.countPairs(arr, 3));

        // Find missing elements in a given range
        System.out.println(MissingElementInRange.missingRange(arr, 3, 10));

        // Find most frequent character
        String s = "ragranjan";
        System.out.println(MostFrequentChar.getMaxOccuringChar(s));

        // Check whether array b is a subset of array a
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};
        System.out.println(ArraySubset.isSubset(a, b));

        // Check whether String s1 and S2 Anagram
        String s1= "latent", s2 = "talent";
        System.out.println(ValidAnagram.areAnagrams(s1,s2));
    }
}
