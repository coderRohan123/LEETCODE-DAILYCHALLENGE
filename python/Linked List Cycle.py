class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def hasCycle(self, head):
        try:
            slow = head
            fast = head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            return True
        except AttributeError:
            return False


def create_linked_list(values, pos):
    if not values:
        return None

    nodes = [ListNode(val) for val in values]
    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]

    if pos < len(nodes):
        nodes[-1].next = nodes[pos]  # Create a cycle

    return nodes[0]


# Example usage
values = [1, 2]
pos = 0

head = create_linked_list(values, pos)

sol = Solution()
result = sol.hasCycle(head)
print(result)
