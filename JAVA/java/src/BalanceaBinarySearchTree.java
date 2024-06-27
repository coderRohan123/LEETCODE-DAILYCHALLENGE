import java.util.*;

// Definition for a binary tree node.

public class BalanceaBinarySearchTree {

    // Method to balance a BST
    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Perform in-order traversal to collect all node values into a sorted list
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);

        // Step 2: Construct a balanced BST from sorted list
        return constructBalancedBST(sortedList, 0, sortedList.size() - 1);
    }

    // In-order traversal to collect node values into sorted list
    private void inorderTraversal(TreeNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, sortedList);
        sortedList.add(node.val);
        inorderTraversal(node.right, sortedList);
    }

    // Recursive method to construct a balanced BST from sorted list
    private TreeNode constructBalancedBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = constructBalancedBST(sortedList, start, mid - 1);
        root.right = constructBalancedBST(sortedList, mid + 1, end);
        return root;
    }

    // Method to convert balanced BST to level-order list format
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

    // Example usage
    public static void main(String[] args) {
        // Example input: [1,null,2,null,3,null,4,null,null]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        BalanceaBinarySearchTree solution = new BalanceaBinarySearchTree();
        TreeNode balancedRoot = solution.balanceBST(root);
        List<Integer> levelOrder = solution.bstToLevelOrder(balancedRoot);

        System.out.println(levelOrder); // Output: [2, 1, 3, null, null, null, 4] or [3, 1, 4, null, 2] or any valid balanced BST
    }
}

