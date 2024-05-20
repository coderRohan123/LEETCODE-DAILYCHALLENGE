import java.util.LinkedList;
import java.util.Queue;

class Tree9999 {
    int val;
    Tree9999 left;
    Tree9999 right;

    Tree9999(int x) {
        val = x;
    }
}

public class DeleteLeavesWithaGivenValue {

    public Tree9999 removeLeafNodes(Tree9999 root, int target) {
        // Base case
        if (root == null) {
            return null;
        }

        // 1. Visit the left children
        root.left = removeLeafNodes(root.left, target);

        // 2. Visit the right children
        root.right = removeLeafNodes(root.right, target);

        // 3. Check if the current node is a leaf node and its value equals target
        if (root.left == null && root.right == null && root.val == target) {
            // Delete the node by returning null to the parent, effectively disconnecting it
            return null;
        }

        // Keep it untouched otherwise
        return root;
    }

    public Tree9999 buildTreeFromList(Integer[] values) {
        if (values.length == 0) {
            return null;
        }

        Tree9999 root = new Tree9999(values[0]);
        Queue<Tree9999> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            Tree9999 current = queue.poll();
            if (values[i] != null) {
                current.left = new Tree9999(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new Tree9999(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        DeleteLeavesWithaGivenValue treeEvaluator = new DeleteLeavesWithaGivenValue();

        // Input: [1, 3, 3, 3, 2], target = 3
        Integer[] inputArray = {1, 3, 3, 3, 2};
        int target = 3;

        Tree9999 root = treeEvaluator.buildTreeFromList(inputArray);
        root = treeEvaluator.removeLeafNodes(root, target);

        // You can add additional code to print the tree if needed to verify the result
        treeEvaluator.printTree(root);  // Print the tree to verify the result
    }

    // Helper method to print the tree (level-order traversal)
    public void printTree(Tree9999 root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<Tree9999> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree9999 current = queue.poll();
            if (current == null) {
                System.out.print("null ");
            } else {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        System.out.println();
    }
}
