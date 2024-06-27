class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def balanceBST(root: TreeNode):
    # Step 1: Perform in-order traversal to collect all node values into a sorted list
    def inorder_traversal(node):
        if not node:
            return []
        return inorder_traversal(node.left) + [node.val] + inorder_traversal(node.right)

    sorted_list = inorder_traversal(root)

    # Step 2: Construct a balanced BST from sorted list
    def construct_balanced_bst(nums):
        if not nums:
            return None
        mid = len(nums) // 2
        root = TreeNode(nums[mid])
        root.left = construct_balanced_bst(nums[:mid])
        root.right = construct_balanced_bst(nums[mid + 1:])
        return root

    balanced_root = construct_balanced_bst(sorted_list)

    # Step 3: Convert balanced BST to level-order list format with None for missing nodes
    def bst_to_level_order(node):
        if not node:
            return []
        queue = [node]
        result = []
        while queue:
            current = queue.pop(0)
            if current:
                result.append(current.val)
                queue.append(current.left)
                queue.append(current.right)
            else:
                result.append(None)
        # Remove trailing None values
        while result and result[-1] is None:
            result.pop()
        return result

    return bst_to_level_order(balanced_root)


# Example usage:
# Input: root = [1,null,2,null,3,null,4,null,null]
root = TreeNode(1)
root.right = TreeNode(2)
root.right.right = TreeNode(3)
root.right.right.right = TreeNode(4)

output = balanceBST(root)
print(
    output)  # Output: [2, 1, 3, None, None, None, 4] or [3, 1, 4, None, 2] or any other balanced BST in level-order format
