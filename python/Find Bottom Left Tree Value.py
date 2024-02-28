class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BottomLeftValue:
    def __init__(self):
        self.max_depth = -1
        self.bottom_left_value = 0

    def find_bottom_left_value(self, root):
        self.max_depth = -1
        self.bottom_left_value = 0
        self.dfs(root, 0)
        return self.bottom_left_value

    def dfs(self, current, depth):
        if not current:
            return
        if depth > self.max_depth:
            self.max_depth = depth
            self.bottom_left_value = current.val
        self.dfs(current.left, depth + 1)
        self.dfs(current.right, depth + 1)

    def construct_binary_tree(self, array):
        if not array or len(array) == 0:
            return None

        root = TreeNode(array[0])
        queue = [root]

        i = 1
        while i < len(array):
            current = queue.pop(0)

            if array[i] is not None:
                current.left = TreeNode(array[i])
                queue.append(current.left)

            i += 1

            if i < len(array) and array[i] is not None:
                current.right = TreeNode(array[i])
                queue.append(current.right)

            i += 1

        return root

if __name__ == "__main__":
    # Example input: [2, 1, 3]
    array = [2, 1, 3]

    # Create an instance of BottomLeftValue class
    solution = BottomLeftValue()

    # Create TreeNode object from the input array
    root = solution.construct_binary_tree(array)

    # Call the method with the created TreeNode object
    result = solution.find_bottom_left_value(root)

    # Print the result
    print(result)
'''
Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7'''