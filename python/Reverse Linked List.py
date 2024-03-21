class ListNode1:
    def __init__(self, val):
        self.val = val
        self.next = None

    @staticmethod
    def reverseList(head):
        # Initialize prev pointer as NULL...
        prev = None
        # Initialize the curr pointer as the head...
        curr = head
        # Run a loop till curr points to NULL...
        while curr:
            # Initialize next pointer as the next pointer of curr...
            next_node = curr.next
            # Now assign the prev pointer to curr’s next pointer.
            curr.next = prev
            # Assign curr to prev, next to curr...
            prev = curr
            curr = next_node
        return prev


# Function to create a linked list from a list of values
def create_linked_list(values):
    if not values:
        return None
    head = ListNode1(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode1(val)
        current = current.next
    return head


# Function to print the linked list
def print_linked_list(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


# Example usage:
if __name__ == "__main__":
    # Input list
    input_list = [1, 2, 3, 4, 5]
    # Creating linked list
    head = create_linked_list(input_list)
    # Reversing the linked list
    reversed_head = ListNode1.reverseList(head)
    # Printing reversed linked list
    print("Reversed linked list:")
    print_linked_list(reversed_head)

'''
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []'''