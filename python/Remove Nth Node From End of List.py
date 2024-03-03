class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head, n):
        def index(node):
            if not node:
                return 0
            i = index(node.next) + 1
            if i > n:
                node.next.val = node.val
            return i

        index(head)
        return head.next

# Example usage:
# Create your linked list
head = ListNode(1)
head.next = ListNode(2)

# Test the removeNthFromEnd method
solution = Solution()
result = solution.removeNthFromEnd(head, 1)

# Print the result or perform any other necessary operations
while result:
    print(result.val, end=" ")
    result = result.next
