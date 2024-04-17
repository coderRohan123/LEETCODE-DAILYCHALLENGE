import java.util.LinkedList;
import java.util.Queue;

class TreeNode4 {
    int val;
    TreeNode4 left, right;

    TreeNode4(int val) {
        this.val = val;
    }
}

public class SumofLeftLeaves {
    public static TreeNode4 arrayToTree(Object[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        Queue<TreeNode4> queue = new LinkedList<>();
        TreeNode4 root = new TreeNode4((int) arr[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode4 currNode = queue.poll();

            if (arr[i] != null) {
                currNode.left = new TreeNode4((int) arr[i]);
                queue.offer(currNode.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                currNode.right = new TreeNode4((int) arr[i]);
                queue.offer(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static int sumOfLeftLeaves(TreeNode4 root) {
        return dfs(root, false);
    }

    private static int dfs(TreeNode4 node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return isLeft ? node.val : 0;
        int leftSum = dfs(node.left, true);
        int rightSum = dfs(node.right, false);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Object[] inputArray = {3, 9, 20, null, null, 15, 7};
        TreeNode4 root = arrayToTree(inputArray);
        System.out.println(sumOfLeftLeaves(root));
    }
}

