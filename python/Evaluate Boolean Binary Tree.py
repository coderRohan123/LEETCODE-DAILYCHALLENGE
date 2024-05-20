from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def evaluateTree(root: Optional[TreeNode]) -> bool:
    if not root.left and not root.right:
        # Handles the case for leaf nodes.
        return root.val != 0

    # Store the evaluations for the left subtree and right subtree.
    evaluate_left_subtree = evaluateTree(root.left)
    evaluate_right_subtree = evaluateTree(root.right)
    if root.val == 2:
        evaluate_root = evaluate_left_subtree or evaluate_right_subtree
    else:
        evaluate_root = evaluate_left_subtree and evaluate_right_subtree

    return evaluate_root

def build_tree_from_list(values: List[Optional[int]]) -> Optional[TreeNode]:
    if not values:
        return None

    root = TreeNode(values[0])
    queue = [root]
    i = 1
    while i < len(values):
        current = queue.pop(0)
        if values[i] is not None:
            current.left = TreeNode(values[i])
            queue.append(current.left)
        i += 1
        if i < len(values) and values[i] is not None:
            current.right = TreeNode(values[i])
            queue.append(current.right)
        i += 1

    return root

# Example usage:
# Input: [2, 1, 3, None, None, 0, 1]
input_array = [2, 1, 3, None, None, 0, 1]
root = build_tree_from_list(input_array)
result = evaluateTree(root)
print(result)  # Output: True (for this example)
