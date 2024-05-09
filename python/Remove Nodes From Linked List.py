# Define the ListNode class
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Function to reverse a linked list
def reverse_list(head):
    prev = None
    current = head
    next_temp = None

    # Set each node's next pointer to the previous node
    while current:
        next_temp = current.next
        current.next = prev
        prev = current
        current = next_temp

    return prev


# Function to remove nodes
def removeNodes(head):
    # Reverse the original linked list
    head = reverse_list(head)

    maximum = 0
    prev = None
    current = head

    # Traverse the list deleting nodes
    while current:
        maximum = max(maximum, current.val)

        # Delete nodes that are smaller than maximum
        if current.val < maximum:
            # Delete current by skipping
            if prev:
                prev.next = current.next
            deleted = current
            current = current.next
            deleted.next = None

        # Current does not need to be deleted
        else:
            prev = current
            current = current.next

    # Reverse and return the modified linked list
    return reverse_list(head)


# Function to convert a list to a linked list
def list_to_linked_list(lst):
    if not lst:
        return None
    head = ListNode(lst[0])
    current = head
    for val in lst[1:]:
        current.next = ListNode(val)
        current = current.next
    return head


# Function to print the linked list
def print_linked_list(head):
    current = head
    while current:
        print(current.val, end=" -> ")
        current = current.next
    print("None")


# Example usage:
input_list = [1,1,1,1]
head = list_to_linked_list(input_list)

result = removeNodes(head)

# Print the result
print_linked_list(result)
'''
You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105'''
