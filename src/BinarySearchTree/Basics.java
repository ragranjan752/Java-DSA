
package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Collections;

// Helper class to store both minimum and maximum values
class Twin {
    int max;
    int min;

    Twin(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class Basics {

    public static void main(String[] args) {

        // Create a valid Binary Search Tree
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.right.right = new Node(9);

        // Question 1: Search a value in BST
        System.out.println("Search 2: " + search(root, 2));
        System.out.println("Search 10: " + search(root, 10));

        // Question 2: Insert a value into BST
        root = insert(root, 10);

        // Display BST in sorted order using Inorder Traversal
        System.out.print("Inorder after insertion: ");
        inorder(root);
        System.out.println();

        // Question 3: Find maximum value in a Binary Tree
        System.out.println("Max value: " + max(root));

        // Question 4: Find minimum value in a Binary Tree
        System.out.println("Min value: " + min(root));

        // Question 5: Find minimum and maximum together
        Twin result = MaxMin(root);
        System.out.println("Max: " + result.max);
        System.out.println("Min: " + result.min);

        // Question 6: Find Lowest Common Ancestor in BST
        Node lca = findLCA(root, 1, 10);
        System.out.println(
                "LCA: " + (lca == null ? "Not found" : lca.val)
        );

        // Question 7: Convert BST to Greater Sum Tree
        // This replaces each node with the sum of strictly greater values
        int total = transformTree(root);

        System.out.println("Sum of original values: " + total);

        // Display transformed tree
        System.out.print("Greater Sum Tree Inorder: ");
        inorder(root);
        System.out.println();

        // Question 8: Convert Sorted Array to Balanced BST
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Basics obj = new Basics();
        Node balancedRoot = obj.sortedArrayToBST(arr);

        System.out.print("Balanced BST Inorder: ");
        inorder(balancedRoot);
        System.out.println();
    }

    // ==================================================
    // Question 1: Search in Binary Search Tree
    // Logic:
    // If key is smaller, search left.
    // If key is greater, search right.
    // Return true when the key is found.
    // Time Complexity: O(H)
    // ==================================================
    public static boolean search(Node root, int key) {

        if (root == null) return false;

        if (root.val == key) return true;

        if (key < root.val) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // ==================================================
    // Question 2: Insert a Value into BST
    // Logic:
    // Find the correct null position and insert the node.
    // Duplicate values are not inserted.
    // Time Complexity: O(H)
    // ==================================================
    public static Node insert(Node root, int key) {

        // Empty position found
        if (root == null) {
            return new Node(key);
        }

        // Do not insert duplicate values
        if (root.val == key) {
            return root;
        }

        // Insert into the right subtree
        if (key > root.val) {
            root.right = insert(root.right, key);
        }

        // Insert into the left subtree
        else {
            root.left = insert(root.left, key);
        }

        return root;
    }

    // ==================================================
    // Helper: Inorder Traversal
    // Order: Left -> Root -> Right
    // Inorder traversal of a BST prints sorted values.
    // Time Complexity: O(N)
    // ==================================================
    public static void inorder(Node root) {

        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // ==================================================
    // Question 3: Find Maximum Value in Binary Tree
    // Checks every node, so this works for any Binary Tree.
    // Time Complexity: O(N)
    // ==================================================
    private static int max(Node root) {

        if (root == null) return Integer.MIN_VALUE;

        int leftMax = max(root.left);
        int rightMax = max(root.right);

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    // ==================================================
    // Question 4: Find Minimum Value in Binary Tree
    // Checks every node, so this works for any Binary Tree.
    // Time Complexity: O(N)
    // ==================================================
    private static int min(Node root) {

        if (root == null) return Integer.MAX_VALUE;

        int leftMin = min(root.left);
        int rightMin = min(root.right);

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }

    // ==================================================
    // Question 5: Find Minimum and Maximum Together
    // Twin stores both results in one object.
    // Time Complexity: O(N)
    // ==================================================
    private static Twin MaxMin(Node root) {

        // Base case for an empty subtree
        if (root == null) {
            return new Twin(
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
            );
        }

        // Find min and max in both subtrees
        Twin left = MaxMin(root.left);
        Twin right = MaxMin(root.right);

        // Combine the subtree results with current node
        int max = Math.max(
                root.val,
                Math.max(left.max, right.max)
        );

        int min = Math.min(
                root.val,
                Math.min(left.min, right.min)
        );

        return new Twin(max, min);
    }

    // ==================================================
    // Question 6: Lowest Common Ancestor in BST
    // If both values are smaller, go left.
    // If both values are greater, go right.
    // Otherwise, the current node is the LCA.
    // Assumes both target values exist in the BST.
    // Time Complexity: O(H)
    // ==================================================
    public static Node findLCA(Node root, int p, int q) {

        while (root != null) {

            if (p < root.val && q < root.val) {
                root = root.left;
            } else if (p > root.val && q > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    // ==================================================
    // Question 7: Convert BST to Greater Sum Tree
    // Reverse inorder gives values from largest to smallest.
    // Each node gets the sum of strictly greater values.
    // Returns the sum of all original node values.
    // Time Complexity: O(N)
    // ==================================================
    public static int transformTree(Node root) {

        // Store nodes in inorder order
        ArrayList<Node> arr = new ArrayList<>();
        inorder(root, arr);

        // Reverse order: largest value first
        Collections.reverse(arr);

        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {

            // Save original value before changing it
            int data = arr.get(i).val;

            // Current node gets the sum of greater values
            arr.get(i).val = sum;

            // Add original value for the next node
            sum += data;
        }

        // Total of all original node values
        return sum;
    }

    // Helper: Store node references in inorder sequence
    private static void inorder(Node root, ArrayList<Node> arr) {

        if (root == null) return;

        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }

    // ==================================================
    // Question 8: Convert Sorted Array to Balanced BST
    // Pick the middle element as the root.
    // Left half builds the left subtree.
    // Right half builds the right subtree.
    // Time Complexity: O(N)
    // ==================================================
    public Node sortedArrayToBST(int[] arr) {

        int n = arr.length;
        return convert(arr, 0, n - 1);
    }

    // Helper: Build balanced BST using array boundaries
    private Node convert(int[] arr, int lo, int hi) {

        // No elements remaining
        if (lo > hi) return null;

        // Find middle index safely
        int mid = lo + (hi - lo) / 2;

        // Middle element becomes the root
        Node root = new Node(arr[mid]);

        // Build left subtree
        root.left = convert(arr, lo, mid - 1);

        // Build right subtree
        root.right = convert(arr, mid + 1, hi);

        return root;
    }
}
