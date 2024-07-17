from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class StepByStepDirectionsFromaBinaryTreeNodetoAnother:
    def get_directions(self, root, start_value, dest_value):
        # Find the Lowest Common Ancestor (LCA) of start and destination nodes
        lowest_common_ancestor = self.find_lowest_common_ancestor(root, start_value, dest_value)

        path_to_start = []
        path_to_dest = []

        # Find paths from LCA to start and destination nodes
        self.find_path(lowest_common_ancestor, start_value, path_to_start)
        self.find_path(lowest_common_ancestor, dest_value, path_to_dest)

        directions = []

        # Add "U" for each step to go up from start to LCA
        directions.extend(['U'] * len(path_to_start))

        # Append the path from LCA to destination
        directions.extend(path_to_dest)

        return ''.join(directions)

    def find_lowest_common_ancestor(self, node, value1, value2):
        if not node:
            return None

        if node.val == value1 or node.val == value2:
            return node

        left_lca = self.find_lowest_common_ancestor(node.left, value1, value2)
        right_lca = self.find_lowest_common_ancestor(node.right, value1, value2)

        if left_lca and right_lca:
            return node

        return left_lca if left_lca else right_lca

    def find_path(self, node, target_value, path):
        if not node:
            return False

        if node.val == target_value:
            return True

        # Try left subtree
        path.append('L')
        if self.find_path(node.left, target_value, path):
            return True
        path.pop()

        # Try right subtree
        path.append('R')
        if self.find_path(node.right, target_value, path):
            return True
        path.pop()

        return False


def build_tree_from_list(values):
    if not values:
        return None

    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    while i < len(values):
        node = queue.popleft()
        if i < len(values) and values[i] is not None:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1
        if i < len(values) and values[i] is not None:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1
    return root


if __name__ == "__main__":
    # Example usage
    tree_values = [5, 1, 2, 3, None, 6, 4]
    start_value = 3
    dest_value = 6

    root = build_tree_from_list(tree_values)

    solver = StepByStepDirectionsFromaBinaryTreeNodetoAnother()
    result = solver.get_directions(root, start_value, dest_value)
    print(result)  # Expected output: "UURL"
