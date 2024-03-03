class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        // Move fast pointer to the (n + 1)-th node from the beginning
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the N-th node from the end
        slow.next = slow.next.next;

        return start.next;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        RemoveNthNodeFromEndofList ob = new RemoveNthNodeFromEndofList();
        ListNode result = ob.removeNthFromEnd(head, 1);

        // Print the result or perform any other necessary operations
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

