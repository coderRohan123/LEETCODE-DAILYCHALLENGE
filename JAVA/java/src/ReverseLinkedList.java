
class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class ReversedLinkedList {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            return prev;
        }

        // Function to create a linked list from an array of values
        public ListNode createLinkedList(int[] values) {
            if (values == null || values.length == 0) {
                return null;
            }
            ListNode head = new ListNode(values[0]);
            ListNode current = head;
            for (int i = 1; i < values.length; i++) {
                current.next = new ListNode(values[i]);
                current = current.next;
            }
            return head;
        }

        // Function to print the linked list
        public void printLinkedList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ReversedLinkedList reversedLinkedList = new ReversedLinkedList();

        // Input array
        int[] inputArray = {1, 2, 3, 4, 5};

        // Creating linked list
        ListNode head = reversedLinkedList.createLinkedList(inputArray);

        // Reversing the linked list
        ListNode reversedHead = reversedLinkedList.reverseList(head);

        // Printing reversed linked list
        System.out.println("Reversed linked list:");
        reversedLinkedList.printLinkedList(reversedHead);
    }
}


