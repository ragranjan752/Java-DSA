
package BinaryTree2;

import java.util.ArrayList;

public class BalanceBinaryTree {

    // Binary Tree Node Structure
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Create a sample binary tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.left.left = new Node(4);

        // Question 1: Check if Binary Tree is Height Balanced
        System.out.println("Balanced: " + isBalanced(root));

        // Question 2: Find the Right View of Binary Tree
        System.out.println("Right View: " + rightView(root));

        // Question 3: Find Lowest Common Ancestor (LCA)
        Node result = lca(root, 2, 4);
        System.out.println("LCA: " +
                (result == null ? "null" : result.val));

        // Question 4: Find Distance Between Two Nodes
        System.out.println("Distance: " + findDist(root, 2, 5));

        // Question 5: Boundary Traversal of Binary Tree
        System.out.println("Boundary: " + boundaryTraversal(root));

        // Question 6: Flatten Binary Tree to Linked List
        int count = flatten(root);
        System.out.println("Node count: " + count);

        // Display the Flattened Tree
        Node temp = root;
        System.out.print("Flattened Tree: ");

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.right;
        }

        System.out.println();
    }

    // ==================================================
    // Question 1: Balanced Binary Tree
    // Approach: Recursion + Height Calculation
    // Return -1 if any subtree is unbalanced
    // Time Complexity: O(N)
    // ==================================================
    public static boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        if (left == -1) return -1;

        int right = height(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    // ==================================================
    // Question 2: Binary Tree Right Side View
    // Approach: DFS, Right First
    // First node visited at each level is added
    // Time Complexity: O(N)
    // ==================================================
    public static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        view(root, 0, ans);
        return ans;
    }

    private static void view(
            Node root, int level, ArrayList<Integer> ans) {

        if (root == null) return;

        // First node visited at this level
        if (level == ans.size()) {
            ans.add(root.val);
        }

        // Visit right subtree before left subtree
        view(root.right, level + 1, ans);
        view(root.left, level + 1, ans);
    }

    // ==================================================
    // Question 3: Lowest Common Ancestor (LCA)
    // Approach: Recursive DFS
    // Find the lowest node containing both target nodes
    // Time Complexity: O(N)
    // Assumption: Both target values are present
    // ==================================================
    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        // Targets found in separate subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return the subtree containing a target
        return left != null ? left : right;
    }

    // ==================================================
    // Question 4: Distance Between Two Nodes
    // Approach: LCA + DFS Depth Calculation
    // Distance = depth of A + depth of B from their LCA
    // Return -1 if either target node is missing
    // ==================================================
    public static int findDist(Node root, int a, int b) {
        // Find the Lowest Common Ancestor
        Node ancestor = lca(root, a, b);

        if (ancestor == null) return -1;

        // dist[0] stores depth of A
        // dist[1] stores depth of B
        int[] dist = {-1, -1};

        findDepth(ancestor, a, b, 0, dist);

        if (dist[0] == -1 || dist[1] == -1) {
            return -1;
        }

        return dist[0] + dist[1];
    }

    private static void findDepth(
            Node root, int a, int b, int level, int[] dist) {

        if (root == null) return;

        if (root.val == a) dist[0] = level;
        if (root.val == b) dist[1] = level;

        findDepth(root.left, a, b, level + 1, dist);
        findDepth(root.right, a, b, level + 1, dist);
    }

    // ==================================================
    // Question 5: Flatten Binary Tree to Linked List
    // Approach: Preorder Traversal + ArrayList
    // Order: Root -> Left -> Right
    // Set all left pointers to null
    // Connect nodes using right pointers
    // Time Complexity: O(N)
    // ==================================================
    public static int flatten(Node root) {
        ArrayList<Node> list = new ArrayList<>();

        // Store nodes in preorder sequence
        preorder(root, list);

        // Connect nodes in preorder order
        for (int i = 0; i < list.size(); i++) {
            Node current = list.get(i);

            current.left = null;

            if (i + 1 < list.size()) {
                current.right = list.get(i + 1);
            } else {
                current.right = null;
            }
        }

        return list.size();
    }

    // Helper: Store nodes in preorder
    private static void preorder(Node root, ArrayList<Node> list) {
        if (root == null) return;

        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // ==================================================
    // Question 6: Path Sum II
    // Find all Root-to-Leaf paths with the target sum
    // Approach: DFS + Backtracking
    // Only complete root-to-leaf paths are accepted
    // ==================================================
    public static ArrayList<ArrayList<Integer>> printPaths(
            Node root, int sum) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, path, ans, sum);
        return ans;
    }

    private static void dfs(
            Node root,
            ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> ans,
            int sum) {

        if (root == null) return;

        // Add current node to the path
        path.add(root.val);

        // Subtract current node value from remaining sum
        sum -= root.val;

        // Accept only leaf paths with the target sum
        if (root.left == null
                && root.right == null
                && sum == 0) {

            // Store a copy because path will be modified
            ans.add(new ArrayList<>(path));
        }

        // Explore both subtrees
        dfs(root.left, path, ans, sum);
        dfs(root.right, path, ans, sum);

        // Backtracking: remove current node
        path.remove(path.size() - 1);
    }

    // ==================================================
    // Question 7: Boundary Traversal of Binary Tree
    // Order: Root -> Left Boundary -> Leaf Nodes
    //        -> Right Boundary (Bottom to Top)
    // Approach: DFS + Boundary Conditions
    // Time Complexity: O(N)
    // ==================================================
    public static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // Add root only once
        ans.add(root.val);

        // If root is the only node, return immediately
        if (root.left == null && root.right == null) {
            return ans;
        }

        // Step 1: Left boundary, excluding leaf nodes
        leftBoundary(root.left, ans);

        // Step 2: All leaf nodes from left to right
        leafNodes(root, ans);

        // Step 3: Right boundary in reverse order
        rightBoundary(root.right, ans);

        return ans;
    }

    // Helper: Add left boundary from top to bottom
    // Prefer left child, otherwise follow right child
    private static void leftBoundary(
            Node root, ArrayList<Integer> ans) {

        if (root == null) return;

        // Do not add leaf nodes here
        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.val);

        if (root.left != null) {
            leftBoundary(root.left, ans);
        } else {
            leftBoundary(root.right, ans);
        }
    }

    // Helper: Add every leaf node from left to right
    private static void leafNodes(
            Node root, ArrayList<Integer> ans) {

        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return;
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    // Helper: Add right boundary from bottom to top
    // Prefer right child, otherwise follow left child
    private static void rightBoundary(
            Node root, ArrayList<Integer> ans) {

        if (root == null) return;

        // Do not add leaf nodes here
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            rightBoundary(root.right, ans);
        } else {
            rightBoundary(root.left, ans);
        }

        // Add after recursion to reverse the order
        ans.add(root.val);
    }
}
