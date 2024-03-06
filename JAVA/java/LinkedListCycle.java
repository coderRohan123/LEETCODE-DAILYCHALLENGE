class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        try {
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static ListNode createLinkedList(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }

        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        if (pos < values.length) {
            nodes[values.length - 1].next = nodes[pos];  // Create a cycle
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        int[] values = {1, 2};
        int pos = 0;

        ListNode head = createLinkedList(values, pos);

        LinkedListCycle solution = new LinkedListCycle();
        boolean result = solution.hasCycle(head);
        System.out.println(result);
    }
}

