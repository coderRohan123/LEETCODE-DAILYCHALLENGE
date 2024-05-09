class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def doubleLinkedList(head):
    # Reverse the given linked list
    def reverseList(head):
        prev = None
        current = head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return prev

    # Reverse the linked list
    head = reverseList(head)

    carry = 0
    current = head

    # Traverse the linked list and double the values
    while current:
        new_val = current.val * 2 + carry
        current.val = new_val % 10
        carry = new_val // 10
        if not current.next and carry:
            current.next = ListNode(carry)
            break
        current = current.next

    # Reverse the linked list back
    return reverseList(head)


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
input_list = [9,9,9]
head = list_to_linked_list(input_list)

result = doubleLinkedList(head)

print_linked_list(result)
'''
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
Example 2:


Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.'''
