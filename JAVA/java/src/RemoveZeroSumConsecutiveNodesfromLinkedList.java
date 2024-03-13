import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0);
        front.next = head;

        ListNode current = front;

        int prefixSum = 0;

        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        prefixSumToNode.put(0, front);

        while (current != null) {
            prefixSum += current.val;
            prefixSumToNode.put(prefixSum, current);
            current = current.next;
        }

        prefixSum = 0;
        current = front;

        while (current != null) {
            prefixSum += current.val;
            current.next = prefixSumToNode.get(prefixSum).next;
            current = current.next;
        }

        return front.next;
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodesfromLinkedList ob = new RemoveZeroSumConsecutiveNodesfromLinkedList();
        ListNode head = arrayToLinkedList(new int[]{1, 2, -3, 3, 1});
        ListNode result = ob.removeZeroSumSublists(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
