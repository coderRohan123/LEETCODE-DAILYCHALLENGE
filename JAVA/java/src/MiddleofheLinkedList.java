/*class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}*/

class Solution1 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class MiddleofheLinkedList {
    public static void main(String[] args) {
        // Creating a linked list from the input [1,2,3,4,5]
        int[] inputArray = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(inputArray[0]);
        ListNode current = head;
        for (int i = 1; i < inputArray.length; i++) {
            current.next = new ListNode(inputArray[i]);
            current = current.next;
        }

        // Creating an instance of the Solution class
        Solution1 solution = new Solution1();

        // Calling the middleNode method with the created linked list
        ListNode result = solution.middleNode(head);

        // Constructing the output as a list
        System.out.print("Input: head = [");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(", ");
            }
            temp = temp.next;
        }
        System.out.println("]");

        System.out.print("Output: [");
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(", ");
            }
            result = result.next;
        }
        System.out.println("]");
    }
}

