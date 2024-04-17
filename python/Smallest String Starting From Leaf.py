from collections import deque
from typing import Optional

# TreeNode definition
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def list_to_tree(nums):
    if not nums:
        return None

    root = TreeNode(nums[0])
    queue = deque([root])
    i = 1

    while i < len(nums):
        node = queue.popleft()

        if nums[i] is not None:
            node.left = TreeNode(nums[i])
            queue.append(node.left)
        i += 1

        if i < len(nums) and nums[i] is not None:
            node.right = TreeNode(nums[i])
            queue.append(node.right)
        i += 1

    return root

def smallestFromLeaf(root: Optional[TreeNode]) -> str:
    if not root:
        return ""

    smallest_string = ""
    node_queue = deque()
    node_queue.append((root, chr(root.val + ord('a'))))

    while node_queue:
        node, current_string = node_queue.popleft()

        if not node.left and not node.right:
            smallest_string = min(smallest_string, current_string) if smallest_string else current_string

        if node.left:
            node_queue.append((node.left, chr(node.left.val + ord('a')) + current_string))

        if node.right:
            node_queue.append((node.right, chr(node.right.val + ord('a')) + current_string))

    return smallest_string

# Example usage:
nums = [0,1,2,3,4,3,4]
tree = list_to_tree(nums)
print(smallestFromLeaf(tree))
'''
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.



Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"
Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"
Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
'''