import java.util.LinkedList;
import java.util.Queue;

class Tree999 {
    int val;
    Tree999 left;
    Tree999 right;

    Tree999(int x) {
        val = x;
    }
}

public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(Tree999 root) {
        if (root.left == null && root.right == null) {
            // Handles the case for leaf nodes.
            return root.val != 0;
        }

        // Store the evaluations for the left subtree and right subtree.
        boolean evaluateLeftSubtree = evaluateTree(root.left);
        boolean evaluateRightSubtree = evaluateTree(root.right);

        if (root.val == 2) {
            return evaluateLeftSubtree || evaluateRightSubtree;
        } else {
            return evaluateLeftSubtree && evaluateRightSubtree;
        }
    }

    public Tree999 buildTreeFromList(Integer[] values) {
        if (values.length == 0) {
            return null;
        }

        Tree999 root = new Tree999(values[0]);
        Queue<Tree999> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            Tree999 current = queue.poll();
            if (values[i] != null) {
                current.left = new Tree999(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new Tree999(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        EvaluateBooleanBinaryTree treeEvaluator = new EvaluateBooleanBinaryTree();

        // Input: [2, 1, 3, null, null, 0, 1]
        Integer[] inputArray = {2, 1, 3, null, null, 0, 1};

        Tree999 root = treeEvaluator.buildTreeFromList(inputArray);
        boolean result = treeEvaluator.evaluateTree(root);

        System.out.println(result);  // Output: true
    }
}

