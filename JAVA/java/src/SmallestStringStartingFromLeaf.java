import java.util.*;

class TreeNode7 {
    int val;
    TreeNode7 left, right;

    TreeNode7(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode7 root) {
        if (root == null)
            return "";

        String smallestString = "";
        Queue<Map.Entry<TreeNode7, String>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new AbstractMap.SimpleEntry<>(root, String.valueOf((char) (root.val + 'a'))));

        while (!nodeQueue.isEmpty()) {
            Map.Entry<TreeNode7, String> entry = nodeQueue.poll();
            TreeNode7 node = entry.getKey();
            String currentString = entry.getValue();

            if (node.left == null && node.right == null) {
                if (smallestString.isEmpty() || currentString.compareTo(smallestString) < 0)
                    smallestString = currentString;
            }

            if (node.left != null)
                nodeQueue.offer(new AbstractMap.SimpleEntry<>(node.left, (char) (node.left.val + 'a') + currentString));

            if (node.right != null)
                nodeQueue.offer(new AbstractMap.SimpleEntry<>(node.right, (char) (node.right.val + 'a') + currentString));
        }

        return smallestString;
    }

    public static TreeNode7 arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        TreeNode7 root = new TreeNode7(arr[0]);
        Queue<TreeNode7> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode7 currNode = queue.poll();

            if (arr[i] != null) {
                currNode.left = new TreeNode7(arr[i]);
                queue.offer(currNode.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                currNode.right = new TreeNode7(arr[i]);
                queue.offer(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {0, 1, 2, 3, 4, 3, 4};
        TreeNode7 root = arrayToTree(nums);
        SmallestStringStartingFromLeaf solution = new SmallestStringStartingFromLeaf();
        System.out.println(solution.smallestFromLeaf(root));
    }
}
