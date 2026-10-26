
package BinarySearchTree;

import java.util.*;
import BinaryTree.Node;

class Quad {
    int max;
    int min;
    int size;
    boolean isBST;

    Quad(int max, int min, int size, boolean isBST) {
        this.max = max;
        this.min = min;
        this.size = size;
        this.isBST = isBST;
    }
}

public class Implementation {

    public static void main(String[] args) {

        // Create a valid Binary Search Tree
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.right.right = new Node(9);

        // 1. Find the size of the largest BST
        System.out.println("Largest BST Size: " + largestBst(root));

        // 2. Print inorder traversal using Morris Traversal
        System.out.println("Morris Traversal: " + MorrisTraversal(root));

        // 3. Check whether the tree is a BST
        System.out.println("Is BST: " + isBST(root));

        // 4. Flatten the tree into a right-skewed tree
        Flatten(root);
        System.out.print("Flattened Tree: ");
        displayRight(root);

        System.out.println("Before deletion:");
        System.out.println(MorrisTraversal(root));

        root = delNode(root, 9);

        System.out.println("After deletion:");
        System.out.println(MorrisTraversal(root));
    }

    // Stores the largest BST subtree size
    static int maxSize;

    public static int largestBst(Node root) {
        maxSize = 0;
        helper(root);
        return maxSize;
    }

    // Returns max, min, size and BST status for a subtree
    static Quad helper(Node root) {

        // An empty subtree is a valid BST
        if (root == null) {
            return new Quad(
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE,
                    0,
                    true
            );
        }

        // Get information from left and right subtrees
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);

        // Find maximum and minimum of the current subtree
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));

        // Total number of nodes in the current subtree
        int size = 1 + lst.size + rst.size;

        // Current subtree is a BST only if both subtrees
        // are BSTs and their values follow BST rules
        boolean isBST = lst.isBST
                && rst.isBST
                && lst.max < root.val
                && rst.min > root.val;

        // Update answer only when the current subtree is a BST
        if (isBST) {
            maxSize = Math.max(maxSize, size);
        }

        return new Quad(max, min, size, isBST);
    }

    // Inorder traversal without recursion or a stack
    public static ArrayList<Integer> MorrisTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();
        Node curr = root;

        while (curr != null) {

            // If left child exists, find its inorder predecessor
            if (curr.left != null) {
                Node pred = curr.left;

                // Stop at the rightmost node or an existing thread
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Create a temporary link back to current node
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Remove the temporary link
                    pred.right = null;

                    // Visit current node
                    ans.add(curr.val);
                    curr = curr.right;
                }

            } else {
                // No left subtree, visit and move right
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        return ans;
    }

    // Checks whether the tree is a valid BST
    // Uses Morris inorder traversal
    public static boolean isBST(Node root) {

        Node curr = root;

        // Use a separate flag instead of a numeric sentinel
        boolean hasPrev = false;
        int prev = 0;

        while (curr != null) {

            if (curr.left != null) {
                Node pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Create temporary thread
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Remove thread before processing current node
                    pred.right = null;

                    // Inorder values of a BST must be strictly increasing
                    if (hasPrev && curr.val <= prev) {
                        return false;
                    }

                    prev = curr.val;
                    hasPrev = true;

                    curr = curr.right;
                }

            } else {
                // Visit current node directly
                if (hasPrev && curr.val <= prev) {
                    return false;
                }

                prev = curr.val;
                hasPrev = true;

                curr = curr.right;
            }
        }

        return true;
    }

    // Flattens the tree into a right-skewed tree
    // Follows preorder order: Root -> Left -> Right
    public static void Flatten(Node root) {

        Node curr = root;

        while (curr != null) {

            if (curr.left != null) {

                // Find the rightmost node in the left subtree
                Node pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                // Attach the original right subtree after predecessor
                pred.right = curr.right;

                // Move the left subtree to the right
                curr.right = curr.left;

                // Remove the left link
                curr.left = null;
            }

            // Move to the next node in the flattened tree
            curr = curr.right;
        }
    }

    // Displays the flattened tree using right pointers
    public static void displayRight(Node root) {

        Node curr = root;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }

        System.out.println();
    }

    public static Node delNode(Node root, int target) {

        // Base case: target nahi mila
        if (root == null) {
            return null;
        }

        // Target chhota hai, left subtree mein search karo
        if (target < root.val) {
            root.left = delNode(root.left, target);
        }

        // Target bada hai, right subtree mein search karo
        else if (target > root.val) {
            root.right = delNode(root.right, target);
        }

        // Target mil gaya
        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            // Find inorder predecessor, maximum in left subtree
            Node pred = root.left;

            while (pred.right != null) {
                pred = pred.right;
            }

            // Copy predecessor's value into current node
            root.val = pred.val;

            // Delete the duplicate predecessor node
            root.left = delNode(root.left, pred.val);
        }

        return root;
    }
}
