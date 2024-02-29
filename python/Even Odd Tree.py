from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def array_to_tree(arr: list, index: int) -> Optional[TreeNode]:
    if index < len(arr) and arr[index] is not None:
        node = TreeNode(arr[index])
        node.left = array_to_tree(arr, 2 * index + 1)
        node.right = array_to_tree(arr, 2 * index + 2)
        return node
    return None

def isEvenOddTree(root: Optional[TreeNode]) -> bool:
    if root is None:
        return True

    prev = []

    def dfs(current: TreeNode, level: int) -> bool:
        # Base case, an empty tree is Even-Odd
        if current is None:
            return True

        # Compare the parity of current and level
        if current.val % 2 == level % 2:
            return False

        # Add a new level to prev if we've reached a new level
        while len(prev) <= level:
            prev.append(0)

        # If there are previous nodes on this level, check increasing/decreasing
        # If on an even level, check that current's value is greater than the previous on this level
        # If on an odd level, check that current's value is less than the previous on this level
        if prev[level] != 0 and \
                ((level % 2 == 0 and current.val <= prev[level]) or \
                 (level % 2 == 1 and current.val >= prev[level])):
            return False

        # Add current value to prev at index level
        prev[level] = current.val

        # Recursively call DFS on the left and right children
        return dfs(current.left, level + 1) and dfs(current.right, level + 1)

    return dfs(root, 0)

# Given input array
input_array = [1, 10, 4, 3, None, 7, 9, 12, 8, 6, None, None, 2]

# Convert array to tree
root = array_to_tree(input_array, 0)

# Call the function
result = isEvenOddTree(root)
print(result)
