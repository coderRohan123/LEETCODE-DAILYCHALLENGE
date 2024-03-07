class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def middleNode(self, head):
        # While slow moves one step forward, fast moves two steps forward.
        # Finally, when fast reaches the end, slow happens to be in the middle of the linked list.
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

# Creating a linked list from the input [1,2,3,4,5]
input_list = [1, 2, 3, 4, 5]
head = ListNode(input_list[0])
current = head
for val in input_list[1:]:
    current.next = ListNode(val)
    current = current.next

# Creating an instance of the Solution class
solution = Solution()

# Calling the middleNode method with the created linked list
result = solution.middleNode(head)

# Constructing the output as a list
output_list = []
while result:
    output_list.append(result.val)
    result = result.next

# Printing the output in the desired format
print(f"Input: head = {input_list}")
print(f"Output: {output_list}")
