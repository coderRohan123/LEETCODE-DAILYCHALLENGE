class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteNodeinaLinkedList {

    public static void deleteNode(ListNode3 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode3 createLinkedList(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        ListNode3 head = new ListNode3(nums[0]);
        ListNode3 current = head;

        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode3(nums[i]);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode3 head) {
        ListNode3 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Define the linked list
        int[] nums = {4, 5, 1, 9};

        // Create the linked list
        ListNode3 head = createLinkedList(nums);

        // Find the node to be deleted
        ListNode3 nodeToDelete = head;
        while (nodeToDelete.val != 5) {
            nodeToDelete = nodeToDelete.next;
        }

        // Print original linked list
        System.out.println("Original linked list:");
        printLinkedList(head);

        // Delete the given node
        deleteNode(nodeToDelete);

        // Print linked list after deletion
        System.out.println("\nLinked list after deletion:");
        printLinkedList(head);
    }
}
