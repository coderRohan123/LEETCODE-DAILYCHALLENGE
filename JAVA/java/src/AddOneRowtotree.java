import java.util.LinkedList;
import java.util.Queue;

class TreeNode8 {
    int val;
    TreeNode8 left, right;

    TreeNode8(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class AddOneRowToTree {
    public TreeNode8 addOneRow(TreeNode8 root, int v, int d) {
        if (d == 1) {
            TreeNode8 newNode = new TreeNode8(v);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode8> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty() && depth < d - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode8 curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }

        while (!queue.isEmpty()) {
            TreeNode8 curr = queue.poll();
            TreeNode8 left = curr.left;
            TreeNode8 right = curr.right;
            curr.left = new TreeNode8(v);
            curr.right = new TreeNode8(v);
            curr.left.left = left;
            curr.right.right = right;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 6, 3, 1, 5};
        TreeNode8 root = arrayToTree(nums);
        AddOneRowToTree solution = new AddOneRowToTree();
        TreeNode8 result = solution.addOneRow(root, 1, 2);
        printTree(result);
    }

    public static TreeNode8 arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        TreeNode8 root = new TreeNode8(arr[0]);
        Queue<TreeNode8> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode8 currNode = queue.poll();

            if (arr[i] != null) {
                currNode.left = new TreeNode8(arr[i]);
                queue.offer(currNode.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                currNode.right = new TreeNode8(arr[i]);
                queue.offer(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode8 node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }
}
