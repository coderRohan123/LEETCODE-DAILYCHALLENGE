class ListNode1:
    def __init__(self, val):
        self.val = val
        self.next = None

class MergeInBetweenLinkedLists:
    def mergeInBetween(self, list1, a, b, list2):
        start = None
        end = list1

        # Set start to node a - 1 and end to node b
        for index in range(b):
            if index == a - 1:
                start = end
            end = end.next

        # Connect the start node to list2
        start.next = list2

        # Find the tail of list2
        while list2.next is not None:
            list2 = list2.next

        # Set the tail of list2 to end.next
        list2.next = end.next
        end.next = None

        return list1

    def printList(self, head):
        while head is not None:
            print(head.val, end=" ")
            head = head.next
        print()

if __name__ == "__main__":
    ob = MergeInBetweenLinkedLists()

    # Example input
    # list1 = [10,1,13,6,9,5]
    list1 = ListNode1(10)
    list1.next = ListNode1(1)
    list1.next.next = ListNode1(13)
    list1.next.next.next = ListNode1(6)
    list1.next.next.next.next = ListNode1(9)
    list1.next.next.next.next.next = ListNode1(5)

    # list2 = [1000000,1000001,1000002]
    list2 = ListNode1(1000000)
    list2.next = ListNode1(1000001)
    list2.next.next = ListNode1(1000002)

    a = 3
    b = 4

    # Merge list2 into list1 between nodes at indices a and b
    mergedList = ob.mergeInBetween(list1, a, b, list2)

    # Print the merged list for verification
    print("Merged List:")
    ob.printList(mergedList)
'''
You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure indicate the result:


Build the result list and return its head.

 

Example 1:


Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
Example 2:


Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.'''