class ListNode13 {
    int val;
    ListNode13 next;
    ListNode13() {}
    ListNode13(int val) { this.val = val; }
    ListNode13(int val, ListNode13 next) { this.val = val; this.next = next; }
}

public class RemoveNodesFromLinkedList {
    public ListNode13 reverseList(ListNode13 head) {
        ListNode13 prev = null;
        ListNode13 current = head;
        ListNode13 nextTemp = null;

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public ListNode13 removeNodes(ListNode13 head) {
        // Reverse the original linked list
        head = reverseList(head);

        int maximum = 0;
        ListNode13 prev = null;
        ListNode13 current = head;

        // Traverse the list deleting nodes
        while (current != null) {
            maximum = Math.max(maximum, current.val);

            // Delete nodes that are smaller than maximum
            if (current.val < maximum) {
                // Delete current by skipping
                if (prev != null) {
                    prev.next = current.next;
                }
                ListNode13 deleted = current;
                current = current.next;
                deleted.next = null;
            }

            // Current does not need to be deleted
            else {
                prev = current;
                current = current.next;
            }
        }

        // Reverse and return the modified linked list
        return reverseList(head);
    }

    // Function to convert an array to a linked list
    public ListNode13 arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode13 head = new ListNode13(arr[0]);
        ListNode13 current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode13(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Function to print the linked list
    public void printLinkedList(ListNode13 head) {
        ListNode13 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Example usage:
    public static void main(String[] args) {
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();
        int[] inputArray = {5, 2, 13, 3, 8};
        ListNode13 head = solution.arrayToLinkedList(inputArray);
        ListNode13 result = solution.removeNodes(head);
        solution.printLinkedList(result);
    }
}
