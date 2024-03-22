// Rename ListNode class to MyListNode
 class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int x) { val = x; }
}

public class PalindromeLinkedList {
    public boolean isPalindrome(MyListNode head) {
        MyListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public MyListNode reverse(MyListNode head) {
        MyListNode prev = null;
        while (head != null) {
            MyListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        // Input array
        int[] arr = {1, 2, 3, 1};

        // Convert array to linked list
        MyListNode dummy = new MyListNode(-1);
        MyListNode current = dummy;
        for (int num : arr) {
            current.next = new MyListNode(num);
            current = current.next;
        }
        MyListNode head = dummy.next;

        // Test the function
        System.out.println(solution.isPalindrome(head)); // Output: true
    }
}
