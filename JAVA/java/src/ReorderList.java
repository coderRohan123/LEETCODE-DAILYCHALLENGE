class CustomListNode {
    int val;
    CustomListNode next;
    CustomListNode() {}
    CustomListNode(int val) { this.val = val; }
    CustomListNode(int val, CustomListNode next) { this.val = val; this.next = next; }
}

public class ReorderList {
    public void reorderList(CustomListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find the middle of the list
        CustomListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        CustomListNode second = slow.next;
        slow.next = null;
        CustomListNode prev = null;
        while (second != null) {
            CustomListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // Merge two halves
        CustomListNode first = head, secondHead = prev;
        while (secondHead != null) {
            CustomListNode tmp1 = first.next;
            CustomListNode tmp2 = secondHead.next;
            first.next = secondHead;
            secondHead.next = tmp1;
            first = tmp1;
            secondHead = tmp2;
        }
    }

    // Function to convert array to linked list
    public static CustomListNode arrayToList(int[] arr) {
        CustomListNode dummy = new CustomListNode();
        CustomListNode current = dummy;
        for (int num : arr) {
            current.next = new CustomListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Function to print the linked list
    public static void printList(CustomListNode head) {
        CustomListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Test the solution
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        CustomListNode head = arrayToList(arr);

        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        System.out.print("Output: ");
        printList(head); // Output: 1 4 2 3
    }
}
