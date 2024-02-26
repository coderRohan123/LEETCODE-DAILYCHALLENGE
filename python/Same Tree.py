from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isSameTree(p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
    if not p and not q:
        return True
    if not p or not q:
        return False
    if p.val != q.val:
        return False
    else:
        return p.val == q.val and isSameTree(p.left, q.left) and isSameTree(p.right, q.right)

# Create TreeNode objects from the input lists
p = TreeNode(1, TreeNode(2))
q = TreeNode(1, None, TreeNode(2))

# Call the function with the created TreeNode objects
result = isSameTree(p, q)

# Print the result
print(result)
