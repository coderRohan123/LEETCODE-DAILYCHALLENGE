from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def is_leaf_similar(root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
    def dfs(root):
        if root is None:
            return []

        leaves = dfs(root.left) + dfs(root.right)

        return leaves or [root.val]

    return dfs(root1) == dfs(root2)