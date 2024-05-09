class ListNode23 {
    int val;
    ListNode23 next;
    ListNode23() {}
    ListNode23(int val) { this.val = val; }
    ListNode23(int val, ListNode23 next) { this.val = val; this.next = next; }
}

public class DoubleaNumberRepresentedasLinkedList {
    public ListNode23 reverseList(ListNode23 head) {
        ListNode23 prev = null;
        ListNode23 current = head;
        ListNode23 nextTemp = null;

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public ListNode23 doubleLinkedList(ListNode23 head) {
        // Reverse the linked list
        head = reverseList(head);

        int carry = 0;
        ListNode23 current = head;

        // Traverse the linked list and double the values
        while (current != null) {
            int newVal = current.val * 2 + carry;
            current.val = newVal % 10;
            carry = newVal / 10;
            if (current.next == null && carry != 0) {
                current.next = new ListNode23(carry);
                break;
            }
            current = current.next;
        }

        // Reverse the linked list back
        return reverseList(head);
    }

    // Function to convert an array to a linked list
    public ListNode23 arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode23 head = new ListNode23(arr[0]);
        ListNode23 current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode23(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Function to print the linked list
    public void printLinkedList(ListNode23 head) {
        ListNode23 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Example usage:
    public static void main(String[] args) {
        DoubleaNumberRepresentedasLinkedList solution = new DoubleaNumberRepresentedasLinkedList();
        int[] inputArray = {1, 8, 9};
        ListNode23 head = solution.arrayToLinkedList(inputArray);
        ListNode23 result = solution.doubleLinkedList(head);
        solution.printLinkedList(result);
    }
}

