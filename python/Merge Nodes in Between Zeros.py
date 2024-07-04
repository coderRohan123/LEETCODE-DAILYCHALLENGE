class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class MergeNodesinBetweenZeros:
    def mergeNodes(self, head: ListNode) -> ListNode:
        # Start with the first non-zero value.
        head = head.next
        if head is None:
            return head

        # Initialize a dummy head node.
        temp = head
        sum_val = 0
        while temp.val != 0:
            sum_val += temp.val
            temp = temp.next

        # Store the sum in head's value.
        head.val = sum_val
        # Store head's next node as the recursive result for temp node.
        head.next = self.mergeNodes(temp)
        return head

    @staticmethod
    def array_to_list_node(array):
        dummy = ListNode(0)
        current = dummy
        for val in array:
            current.next = ListNode(val)
            current = current.next
        return dummy.next

    @staticmethod
    def print_list(head: ListNode):
        while head:
            print(head.val, end=" -> ")
            head = head.next
        print("None")

if __name__ == "__main__":
    # Example to test the mergeNodes function.
    input_array = [0, 3, 1, 0, 4, 5, 2, 0]
    head = MergeNodesinBetweenZeros.array_to_list_node(input_array)

    merger = MergeNodesinBetweenZeros()
    result = merger.mergeNodes(head)

    # Print the result list
    MergeNodesinBetweenZeros.print_list(result)
