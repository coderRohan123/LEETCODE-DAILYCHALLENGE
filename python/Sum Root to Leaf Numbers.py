from collections import deque

class TreeNode5:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def sumNumbers(root):
    return sum_helper(root, 0)

def sum_helper(node, current_sum):
    if not node:
        return 0
    if not node.left and not node.right:
        return current_sum * 10 + node.val
    left_sum = sum_helper(node.left, current_sum * 10 + node.val)
    right_sum = sum_helper(node.right, current_sum * 10 + node.val)
    return left_sum + right_sum

def array_to_tree(arr):
    if not arr:
        return None

    root = TreeNode5(arr[0])
    queue = deque([root])
    i = 1

    while queue and i < len(arr):
        node = queue.popleft()
        if arr[i] is not None:
            node.left = TreeNode5(arr[i])
            queue.append(node.left)
        i += 1
        if i < len(arr) and arr[i] is not None:
            node.right = TreeNode5(arr[i])
            queue.append(node.right)
        i += 1

    return root

# Example input: root = [1,2,3]
input_array = [1, 2, 3]
root = array_to_tree(input_array)

# Calculate the sum of root-to-leaf numbers
result = sumNumbers(root)
print("Sum of root-to-leaf numbers:", result)
'''
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.'''
