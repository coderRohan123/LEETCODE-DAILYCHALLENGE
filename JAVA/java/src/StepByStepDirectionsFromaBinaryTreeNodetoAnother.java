import java.util.*;

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the Lowest Common Ancestor (LCA) of start and destination nodes
        TreeNode lowestCommonAncestor = findLowestCommonAncestor(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        // Find paths from LCA to start and destination nodes
        findPath(lowestCommonAncestor, startValue, pathToStart);
        findPath(lowestCommonAncestor, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();

        // Add "U" for each step to go up from start to LCA
        directions.append("U".repeat(pathToStart.length()));

        // Append the path from LCA to destination
        directions.append(pathToDest);

        return directions.toString();
    }

    private TreeNode findLowestCommonAncestor(TreeNode node, int value1, int value2) {
        if (node == null) return null;

        if (node.val == value1 || node.val == value2) return node;

        TreeNode leftLCA = findLowestCommonAncestor(node.left, value1, value2);
        TreeNode rightLCA = findLowestCommonAncestor(node.right, value1, value2);

        if (leftLCA == null) return rightLCA;
        else if (rightLCA == null) return leftLCA;
        else return node; // Both values found, this is the LCA
    }

    private boolean findPath(TreeNode node, int targetValue, StringBuilder path) {
        if (node == null) return false;

        if (node.val == targetValue) return true;

        // Try left subtree
        path.append("L");
        if (findPath(node.left, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        // Try right subtree
        path.append("R");
        if (findPath(node.right, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        return false;
    }

    // Helper function to build a tree from a list
    public TreeNode buildTreeFromList(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        StepByStepDirectionsFromaBinaryTreeNodetoAnother solver = new StepByStepDirectionsFromaBinaryTreeNodetoAnother();
        Integer[] treeValues = {5, 1, 2, 3, null, 6, 4};
        int startValue = 3;
        int destValue = 6;

        TreeNode root = solver.buildTreeFromList(treeValues);
        String result = solver.getDirections(root, startValue, destValue);
        System.out.println(result); // Expected output: "UURL"
    }
}



