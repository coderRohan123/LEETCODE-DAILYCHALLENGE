/*class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

public class MergeNodesinBetweenZeros {

    public ListNode mergeNodes(ListNode head) {
        // Start with the first non-zero value.
        head = head.next;
        if (head == null) {
            return head;
        }

        // Initialize a dummy head node.
        ListNode temp = head;
        int sum = 0;
        while (temp.val != 0) {
            sum += temp.val;
            temp = temp.next;
        }

        // Store the sum in head's value.
        head.val = sum;
        // Store head's next node as the recursive result for temp node.
        head.next = mergeNodes(temp);
        return head;
    }

    public static ListNode arrayToListNode(int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : array) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example to test the mergeNodes function.
        int[] input = {0, 3, 1, 0, 4, 5, 2, 0};
        ListNode head = arrayToListNode(input);

        MergeNodesinBetweenZeros merger = new MergeNodesinBetweenZeros();
        ListNode result = merger.mergeNodes(head);

        // Print the result list
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}
