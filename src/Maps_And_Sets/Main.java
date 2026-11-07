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
        String s = "shashiranjan";
        System.out.println(MostFrequentChar.getMaxOccuringChar(s));

        // Check whether array b is a subset of array a
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};
        System.out.println(ArraySubset.isSubset(a, b));

        // Check whether String s1 and s2 are anagrams
        String s1 = "latent", s2 = "talent";
        System.out.println(ValidAnagram.areAnagrams(s1, s2));

        // Longest unique pairs
        System.out.println(LongestUniquePairs.lengthOfLongestPairs(s));

        // Longest non-repeating substring
        System.out.println(longestNonRepeatingSubstr.longestUniqueStr(s));

        // Create Binary Tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);

        // Top View of Binary Tree
        System.out.println(TopViewOfBinaryTree.topView(root));

        // Bottom View of Binary Tree
        System.out.println(BottomViewOfBinaryTree.bottomView(root));

        // Burning Tree
        System.out.println(BurningTree.minTime(root, 40));

        System.out.println(CopyListWithRandomPointer.cloneLinkedList(root));
    }
}