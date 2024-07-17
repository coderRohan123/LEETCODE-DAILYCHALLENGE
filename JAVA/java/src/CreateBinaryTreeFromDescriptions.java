import java.util.*;

public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Step 1: Organize data
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            // Store child information under parent node
            if (!parentToChildren.containsKey(parent)) {
                parentToChildren.put(parent, new ArrayList<>());
            }
            parentToChildren.get(parent).add(new int[] { child, isLeft });
            allNodes.add(parent);
            allNodes.add(child);
            children.add(child);
        }

        // Step 2: Find the root
        int rootVal = 0;
        for (int node : allNodes) {
            if (!children.contains(node)) {
                rootVal = node;
                break;
            }
        }

        // Step 3 & 4: Build the tree using DFS
        return dfs(parentToChildren, rootVal);
    }

    // DFS function to recursively build binary tree
    private TreeNode dfs(Map<Integer, List<int[]>> parentToChildren, int val) {
        // Create new TreeNode for current value
        TreeNode node = new TreeNode(val);

        // If current node has children, recursively build them
        if (parentToChildren.containsKey(val)) {
            for (int[] childInfo : parentToChildren.get(val)) {
                int child = childInfo[0];
                int isLeft = childInfo[1];

                // Attach child node based on isLeft flag
                if (isLeft == 1) {
                    node.left = dfs(parentToChildren, child);
                } else {
                    node.right = dfs(parentToChildren, child);
                }
            }
        }

        return node;
    }

    // Helper function to print the tree (in-order traversal)
    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    // Helper function to print the tree (level-order traversal)
    private void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions treeBuilder = new CreateBinaryTreeFromDescriptions();

        int[][] descriptions = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };

        TreeNode root = treeBuilder.createBinaryTree(descriptions);

        // Print the tree (in-order traversal)
        System.out.print("In-order traversal: ");
        treeBuilder.printTree(root);
        System.out.println();

        // Print the tree (level-order traversal)
        System.out.print("Level-order traversal: ");
        treeBuilder.printTreeLevelOrder(root);  // Expected output: 50 20 80 15 17 19
        System.out.println();
    }
}


