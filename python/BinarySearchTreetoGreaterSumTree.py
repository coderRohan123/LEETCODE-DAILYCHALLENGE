# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def bstToGst(root):
    # Get the node with the smallest value greater than this one.
    def get_successor(node):
        succ = node.right
        while succ.left is not None and succ.left is not node:
            succ = succ.left
        return succ

    total = 0
    node = root
    while node is not None:
        # If there is no right subtree, then we can visit this node and
        # continue traversing left.
        if node.right is None:
            total += node.val
            node.val = total
            node = node.left
        # If there is a right subtree, then there is a node that has a
        # greater value than the current one. therefore, we must traverse
        # that node first.
        else:
            succ = get_successor(node)
            # If there is no left subtree (or right subtree, because we are
            # in this branch of control flow), make a temporary connection
            # back to the current node.
            if succ.left is None:
                succ.left = node
                node = node.right
            # If there is a left subtree, it is a link that we created on
            # a previous pass, so we should unlink it and visit this node.
            else:
                succ.left = None
                total += node.val
                node.val = total
                node = node.left

    return root

# Helper function to construct a tree from list representation
def construct_tree(nodes):
    if not nodes:
        return None
    idx = 0
    root = TreeNode(nodes[idx])
    idx += 1
    queue = [root]
    while queue:
        node = queue.pop(0)
        if idx < len(nodes) and nodes[idx] is not None:
            node.left = TreeNode(nodes[idx])
            queue.append(node.left)
        idx += 1
        if idx < len(nodes) and nodes[idx] is not None:
            node.right = TreeNode(nodes[idx])
            queue.append(node.right)
        idx += 1
    return root

# Helper function to convert tree to list representation
def tree_to_list(root):
    if not root:
        return []
    result = []
    queue = [root]
    while queue:
        node = queue.pop(0)
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)
    while result and result[-1] is None:
        result.pop()
    return result

# Example usage
input_tree = [4,1,6,0,2,5,7,None,None,None,3,None,None,None,8]
root = construct_tree(input_tree)
bstToGst(root)
output_list = tree_to_list(root)
print(output_list)  # Output: [30,36,21,36,35,26,15,None,None,None,33,None,None,None,8]
