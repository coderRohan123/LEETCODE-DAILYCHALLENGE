from typing import Optional, List

class Tree8888:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class DistributeCoinsinBinaryTree:
    def __init__(self):
        self.moves = 0

    def distributeCoins(self, root: Optional[Tree8888]) -> int:
        self.moves = 0
        self.dfs(root)
        return self.moves

    def dfs(self, current: Optional[Tree8888]) -> int:
        if current is None:
            return 0

        # Calculate the coins each subtree has available to exchange
        left_coins = self.dfs(current.left)
        right_coins = self.dfs(current.right)

        # Add the total number of exchanges to moves
        self.moves += abs(left_coins) + abs(right_coins)

        # The number of coins current has available to exchange
        return (current.val - 1) + left_coins + right_coins

    def build_tree_from_list(self, values: List[Optional[int]]) -> Optional[Tree8888]:
        if not values:
            return None

        root = Tree8888(values[0])
        queue = [root]
        i = 1
        while i < len(values):
            current = queue.pop(0)
            if values[i] is not None:
                current.left = Tree8888(values[i])
                queue.append(current.left)
            i += 1
            if i < len(values) and values[i] is not None:
                current.right = Tree8888(values[i])
                queue.append(current.right)
            i += 1

        return root

    def print_tree(self, root: Optional[Tree8888]):
        if root is None:
            print("[]")
            return

        queue = [root]
        while queue:
            current = queue.pop(0)
            if current is None:
                print("null", end=" ")
            else:
                print(current.val, end=" ")
                queue.append(current.left)
                queue.append(current.right)
        print()

# Example usage:
input_array = [3, 0, 0]

tree_builder = DistributeCoinsinBinaryTree()
root = tree_builder.build_tree_from_list(input_array)
result = tree_builder.distributeCoins(root)

print(result)  # Output: 2

# Optional: Print the tree to verify the result
tree_builder.print_tree(root)
