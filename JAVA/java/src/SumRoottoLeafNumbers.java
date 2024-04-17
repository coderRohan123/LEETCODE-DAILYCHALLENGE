import java.util.*;

class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;

    TreeNode5() {}

    TreeNode5(int val) {
        this.val = val;
    }

    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode5 root) {
        return sum(root, 0);
    }

    private int sum(TreeNode5 node, int currentSum) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return currentSum * 10 + node.val;
        int leftSum = sum(node.left, currentSum * 10 + node.val);
        int rightSum = sum(node.right, currentSum * 10 + node.val);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        // Example input: root = [1,2,3]
        Integer[] inputArray = {1, 2, 3};
        TreeNode5 root = arrayToTree(inputArray);

        SumRoottoLeafNumbers solution = new SumRoottoLeafNumbers();
        int result = solution.sumNumbers(root);
        System.out.println("Sum of root-to-leaf numbers: " + result);
    }

    public static TreeNode5 arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        Queue<TreeNode5> queue = new LinkedList<>();
        TreeNode5 root = new TreeNode5(arr[0]);
        queue.offer(root);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode5 current = queue.poll();
            if (arr[i] != null) {
                current.left = new TreeNode5(arr[i]);
                queue.offer(current.left);
            }
            if (i + 1 < arr.length && arr[i + 1] != null) {
                current.right = new TreeNode5(arr[i + 1]);
                queue.offer(current.right);
            }
        }
        return root;
    }
}

