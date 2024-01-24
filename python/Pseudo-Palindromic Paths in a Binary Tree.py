# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths(self, root: Optional[TreeNode]) -> int:
        h = set()
        output = 0

        def set_v(v):
            nonlocal h
            if v in h:
                h.remove(v)
            else:
                h.add(v)

        def check(node):
            nonlocal output, h
            if not node.left and not node.right:
                set_v(node.val)
                if len(h) < 2:
                    output += 1
                set_v(node.val)
                return

            if node.left:
                set_v(node.val)
                check(node.left)
                set_v(node.val)

            if node.right:
                set_v(node.val)
                check(node.right)
                set_v(node.val)

        check(root)
        return output