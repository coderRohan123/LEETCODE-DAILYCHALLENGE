import java.util.LinkedList;
import java.util.Queue;

class Tree8888 {
    int val;
    Tree8888 left;
    Tree8888 right;

    Tree8888(int x) {
        val = x;
    }
}

public class DistributeCoinsinBinaryTree {
    private int moves;

    public int distributeCoins(Tree8888 root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(Tree8888 current) {
        if (current == null) {
            return 0;
        }

        // Calculate the coins each subtree has available to exchange
        int leftCoins = dfs(current.left);
        int rightCoins = dfs(current.right);

        // Add the total number of exchanges to moves
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        // The number of coins current has available to exchange
        return (current.val - 1) + leftCoins + rightCoins;
    }

    public Tree8888 buildTreeFromList(Integer[] values) {
        if (values.length == 0) {
            return null;
        }

        Tree8888 root = new Tree8888(values[0]);
        Queue<Tree8888> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            Tree8888 current = queue.poll();
            if (values[i] != null) {
                current.left = new Tree8888(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new Tree8888(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public void printTree(Tree8888 root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<Tree8888> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree8888 current = queue.poll();
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

    public static void main(String[] args) {
        DistributeCoinsinBinaryTree treeEvaluator = new DistributeCoinsinBinaryTree();

        // Input: [3, 0, 0]
        Integer[] inputArray = {3, 0, 0};

        Tree8888 root = treeEvaluator.buildTreeFromList(inputArray);
        int result = treeEvaluator.distributeCoins(root);

        System.out.println(result);  // Output: 2

        // Optional: Print the tree to verify the result

    }
}

