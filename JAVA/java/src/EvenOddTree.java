import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class EvenOddTree{

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<Integer> prev = new LinkedList<>();
        return dfs(root, 0, prev);
    }

    private static boolean dfs(TreeNode current, int level, LinkedList<Integer> prev) {
        if (current == null) {
            return true;
        }

        // Compare the parity of current and level
        if (current.val % 2 == level % 2) {
            return false;
        }

        // Add a new level to prev if we've reached a new level
        while (prev.size() <= level) {
            prev.add(0);
        }

        // If there are previous nodes on this level, check increasing/decreasing
        // If on an even level, check that current's value is greater than the previous on this level
        // If on an odd level, check that current's value is less than the previous on this level
        if (prev.get(level) != 0 &&
                ((level % 2 == 0 && current.val <= prev.get(level)) ||
                        (level % 2 == 1 && current.val >= prev.get(level)))) {
            return false;
        }

        // Add current value to prev at index level
        prev.set(level, current.val);

        // Recursively call DFS on the left and right children
        return dfs(current.left, level + 1, prev) && dfs(current.right, level + 1, prev);
    }

    // Helper method to convert array to tree
    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode current = queue.poll();
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            if (i + 1 < arr.length && arr[i + 1] != null) {
                current.right = new TreeNode(arr[i + 1]);
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        // Given input array
        Integer[] inputArray = {1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2};

        // Convert array to tree
        TreeNode root = arrayToTree(inputArray);

        // Call the function
        boolean result = isEvenOddTree(root);
        System.out.println(result);
    }
}

