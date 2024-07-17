class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class CreateBinaryTreeFromDescriptions:
    def create_binary_tree(self, descriptions):
        from collections import defaultdict

        # Step 1: Organize data
        parent_to_children = defaultdict(list)
        all_nodes = set()
        children = set()

        for parent, child, is_left in descriptions:
            parent_to_children[parent].append((child, is_left))
            all_nodes.add(parent)
            all_nodes.add(child)
            children.add(child)

        # Step 2: Find the root
        root_val = next(node for node in all_nodes if node not in children)

        # Step 3 & 4: Build the tree using DFS
        return self.dfs(parent_to_children, root_val)

    def dfs(self, parent_to_children, val):
        # Create new TreeNode for current value
        node = TreeNode(val)

        # If current node has children, recursively build them
        for child, is_left in parent_to_children.get(val, []):
            if is_left == 1:
                node.left = self.dfs(parent_to_children, child)
            else:
                node.right = self.dfs(parent_to_children, child)

        return node

    # Helper function to print the tree (in-order traversal)
    def print_tree_in_order(self, root):
        if not root:
            return
        self.print_tree_in_order(root.left)
        print(root.val, end=' ')
        self.print_tree_in_order(root.right)

    # Helper function to print the tree (level-order traversal)
    def print_tree_level_order(self, root):
        if not root:
            return
        from collections import deque
        queue = deque([root])
        while queue:
            node = queue.popleft()
            print(node.val, end=' ')
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

if __name__ == "__main__":
    tree_builder = CreateBinaryTreeFromDescriptions()

    descriptions = [
        [20, 15, 1],
        [20, 17, 0],
        [50, 20, 1],
        [50, 80, 0],
        [80, 19, 1]
    ]

    root = tree_builder.create_binary_tree(descriptions)

    # Print the tree (in-order traversal)
    print("In-order traversal: ", end='')
    tree_builder.print_tree_in_order(root)
    print()

    # Print the tree (level-order traversal)
    print("Level-order traversal: ", end='')
    tree_builder.print_tree_level_order(root)
    print()
