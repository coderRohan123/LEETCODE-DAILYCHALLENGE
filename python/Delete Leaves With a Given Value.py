from typing import Optional, List


# Definition for a binary tree node.
class Tree9999:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class DeleteLeavesWithaGivenValue:

    def removeLeafNodes(self, root: Optional[Tree9999], target: int) -> Optional[Tree9999]:
        # Base case
        if root is None:
            return None

        # 1. Visit the left children
        root.left = self.removeLeafNodes(root.left, target)

        # 2. Visit the right children
        root.right = self.removeLeafNodes(root.right, target)

        # 3. Check if the current node is a leaf node and its value equals target
        if root.left is None and root.right is None and root.val == target:
            # Delete the node by returning None to the parent, effectively disconnecting it
            return None

        # Keep it untouched otherwise
        return root

    def build_tree_from_list(self, values: List[Optional[int]]) -> Optional[Tree9999]:
        if not values:
            return None

        root = Tree9999(values[0])
        queue = [root]
        i = 1
        while i < len(values):
            current = queue.pop(0)
            if values[i] is not None:
                current.left = Tree9999(values[i])
                queue.append(current.left)
            i += 1
            if i < len(values) and values[i] is not None:
                current.right = Tree9999(values[i])
                queue.append(current.right)
            i += 1

        return root

    def print_tree(self, root: Optional[Tree9999]):
        if root is None:
            print("[]")
            return

        queue = [root]
        while queue:
            current = queue.pop(0)
            if current is None:
                print("null", end=" ")
            else:
                print(current.val, end=" ")
                queue.append(current.left)
                queue.append(current.right)
        print()


# Example usage:
# Input: [1, 3, 3, 3, 2], target = 3
input_array = [1, 3, 3, 3, 2]
target = 3

tree_builder = DeleteLeavesWithaGivenValue()
root = tree_builder.build_tree_from_list(input_array)
root = tree_builder.removeLeafNodes(root, target)

# Print the tree to verify the result
tree_builder.print_tree(root)
