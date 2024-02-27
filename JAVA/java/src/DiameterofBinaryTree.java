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

public class DiameterofBinayTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int left = depth(p.left);
        int right = depth(p.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
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
        // Example input: [1, 2, 3, 4, 5]
        Integer[] array = {1, 2, 3, 4, 5};

        // Create an instance of DiameterOfBinaryTree class
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Create TreeNode object from the input array
        TreeNode root = solution.constructBinaryTree(array);

        // Call the method with the created TreeNode object
        int result = solution.diameterOfBinaryTree(root);

        // Print the result
        System.out.println(result);
    }
}
