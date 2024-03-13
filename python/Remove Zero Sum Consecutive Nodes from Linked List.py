# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        front = ListNode(0, head)
        start = front

        while start is not None:
            prefix_sum = 0
            end = start.next

            while end is not None:
                # Add end's value to the prefix sum
                prefix_sum += end.val

                # Delete zero sum consecutive sequence
                # by setting node before sequence to node after
                if prefix_sum == 0:
                    start.next = end.next

                end = end.next

            start = start.next

        return front.next

# Create an instance of the Solution class
sol = Solution()

# Convert the list [1, 2, -3, 3, 1] to a linked list
head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(-3)
head.next.next.next = ListNode(3)
head.next.next.next.next = ListNode(1)

# Call the removeZeroSumSublists method and print the result
result = sol.removeZeroSumSublists(head)

# Print the result
while result:
    print(result.val, end=" ")
    result = result.next
