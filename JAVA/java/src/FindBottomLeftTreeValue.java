import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class FindBottomLeftTreeValue {
    private int maxDepth;
    private int bottomLeftValue;

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        bottomLeftValue = 0;
        dfs(root, 0);
        return bottomLeftValue;
    }

    private void dfs(TreeNode current, int depth) {
        if (current == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = current.val;
        }
        dfs(current.left, depth + 1);
        dfs(current.right, depth + 1);
    }

    private TreeNode constructBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < array.length; i += 2) {
            TreeNode current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }

            if (i + 1 < array.length && array[i + 1] != null) {
                current.right = new TreeNode(array[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        // Example input: [2, 1, 3]
        Integer[] array = {2, 1, 3};

        // Create an instance of BottomLeftValue class
        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();

        // Create TreeNode object from the input array
        TreeNode root = solution.constructBinaryTree(array);

        // Call the method with the created TreeNode object
        int result = solution.findBottomLeftValue(root);

        // Print the result
        System.out.println(result);
    }
}
