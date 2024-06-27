// Definition for a binary tree node.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreetoGreaterSumTree {

    // Method to transform BST to GST
    public TreeNode bstToGst(TreeNode root) {
        // Get the node with the smallest value greater than this one.
        TreeNode[] succ = new TreeNode[1];
        succ[0] = null;
        return bstToGstHelper(root, succ);
    }

    // Helper method for recursion
    private TreeNode bstToGstHelper(TreeNode root, TreeNode[] succ) {
        if (root == null) {
            return null;
        }

        // Recursively traverse the right subtree
        root.right = bstToGstHelper(root.right, succ);

        // Update root's value with accumulated sum
        if (succ[0] != null) {
            root.val += succ[0].val;
        }

        // Update the successor node
        succ[0] = root;

        // Recursively traverse the left subtree
        root.left = bstToGstHelper(root.left, succ);

        return root;
    }

    // Method to convert BST to level-order list format
    public List<Integer> bstToLevelOrder(TreeNode root) {
        List<Integer> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                levelOrderList.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                levelOrderList.add(null);
            }
        }

        // Remove trailing nulls
        while (!levelOrderList.isEmpty() && levelOrderList.get(levelOrderList.size() - 1) == null) {
            levelOrderList.remove(levelOrderList.size() - 1);
        }

        return levelOrderList;
    }

    // Helper method to construct a tree from array representation
    public TreeNode constructTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        return constructTreeHelper(nodes, 0);
    }

    private TreeNode constructTreeHelper(Integer[] nodes, int index) {
        TreeNode root = null;
        if (index < nodes.length && nodes[index] != null) {
            root = new TreeNode(nodes[index]);
            root.left = constructTreeHelper(nodes, 2 * index + 1);
            root.right = constructTreeHelper(nodes, 2 * index + 2);
        }
        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        BinarySearchTreetoGreaterSumTree solution = new BinarySearchTreetoGreaterSumTree();

        // Example input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        Integer[] input = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = solution.constructTree(input);

        // Transform BST to GST
        TreeNode gstRoot = solution.bstToGst(root);

        // Convert GST to level-order list format
        List<Integer> levelOrder = solution.bstToLevelOrder(gstRoot);

        // Print level-order list
        System.out.println(levelOrder);  // Output: [30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8]
    }
}

