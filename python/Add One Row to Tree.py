from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def addOneRow(root, v, d):
    if d == 1:
        return TreeNode(v, root, None)

    bfs = deque([root])
    depth = 1
    while bfs and depth < d - 1:
        size = len(bfs)
        for _ in range(size):
            curr = bfs.popleft()
            if curr.left:
                bfs.append(curr.left)
            if curr.right:
                bfs.append(curr.right)
        depth += 1

    # Add nodes at depth d-1
    while bfs:
        node = bfs.popleft()
        node.left = TreeNode(v, node.left, None)
        node.right = TreeNode(v, None, node.right)

    return root


# Convert the list to a TreeNode object
root_list = [4, 2, 6, 3, 1, 5]
root = TreeNode(root_list[0])
queue = deque([root])
i = 1
while queue and i < len(root_list):
    node = queue.popleft()
    if root_list[i] is not None:
        node.left = TreeNode(root_list[i])
        queue.append(node.left)
    i += 1
    if i < len(root_list) and root_list[i] is not None:
        node.right = TreeNode(root_list[i])
        queue.append(node.right)
    i += 1

# Add one row of nodes
result = addOneRow(root, 1, 2)


# Function to print the tree (optional)
def printTree(node):
    if node:
        print(node.val, end=' ')
        printTree(node.left)
        printTree(node.right)


# Print the modified tree
printTree(result)

'''
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 

Example 1:


Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:


Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
The depth of the tree is in the range [1, 104].
-100 <= Node.val <= 100
-105 <= val <= 105
1 <= depth <= the depth of tree + 1'''




















'''
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.


Example 1:


Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:


Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]


Constraints:

The number of nodes in the tree is in the range [1, 104].
The depth of the tree is in the range [1, 104].
-100 <= Node.val <= 100
-105 <= val <= 105
1 <= depth <= the depth of tree + 1
'''