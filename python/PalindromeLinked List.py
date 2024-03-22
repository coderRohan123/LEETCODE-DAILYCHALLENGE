class MyListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class PalindromeLinkedList:
    def is_palindrome(self, head):
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        if fast:  # odd nodes: let right half smaller
            slow = slow.next

        slow = self.reverse(slow)
        fast = head

        while slow:
            if fast.val != slow.val:
                return False
            fast = fast.next
            slow = slow.next

        return True

    def reverse(self, head):
        prev = None
        while head:
            next_node = head.next
            head.next = prev
            prev = head
            head = next_node
        return prev


if __name__ == "__main__":
    solution = PalindromeLinkedList()

    # Example usage
    # Input: head = [1,2,2,1]
    head = MyListNode(1)
    head.next = MyListNode(2)
    head.next.next = MyListNode(2)
    head.next.next.next = MyListNode(1)

    print(solution.is_palindrome(head))  # Output: True
