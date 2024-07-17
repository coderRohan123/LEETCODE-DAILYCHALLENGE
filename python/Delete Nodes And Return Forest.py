from typing import List, Optional, Set


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class DeleteNodesAndReturnForest:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        to_delete_set = set(to_delete)
        forest = []

        root = self.process_node(root, to_delete_set, forest)

        # If the root is not deleted, add it to the forest
        if root:
            forest.append(root)

        return forest

    def process_node(self, node: Optional[TreeNode], to_delete_set: Set[int], forest: List[TreeNode]) -> Optional[
        TreeNode]:
        if not node:
            return None

        node.left = self.process_node(node.left, to_delete_set, forest)
        node.right = self.process_node(node.right, to_delete_set, forest)

        # Node Evaluation: Check if the current node needs to be deleted
        if node.val in to_delete_set:
            # If the node has left or right children, add them to the forest
            if node.left:
                forest.append(node.left)
            if node.right:
                forest.append(node.right)
            # Return None to its parent to delete the current node
            return None

        return node


def build_tree_from_list(values: List[Optional[int]]) -> Optional[TreeNode]:
    if not values:
        return None

    root = TreeNode(values[0])
    queue = [root]
    i = 1

    while i < len(values):
        current = queue.pop(0)
        if i < len(values) and values[i] is not None:
            current.left = TreeNode(values[i])
            queue.append(current.left)
        i += 1
        if i < len(values) and values[i] is not None:
            current.right = TreeNode(values[i])
            queue.append(current.right)
        i += 1

    return root


def print_forest(forest: List[TreeNode]):
    for tree in forest:
        print_tree(tree)
        print()


def print_tree(root: Optional[TreeNode]):
    if not root:
        return
    queue = [root]
    while queue:
        node = queue.pop(0)
        if node:
            print(node.val, end=" ")
            queue.append(node.left)
            queue.append(node.right)
        else:
            print("null", end=" ")
    print()


if __name__ == "__main__":
    # Example usage
    tree_values = [1, 2, 3, 4, 5, 6, 7]
    to_delete = [3, 5]

    root = build_tree_from_list(tree_values)

    solver = DeleteNodesAndReturnForest()
    forest = solver.delNodes(root, to_delete)

    # Print the forest
    print_forest(forest)
