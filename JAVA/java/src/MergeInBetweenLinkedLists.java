class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
    }
}

public class MergeInBetweenLinkedLists {
    public ListNode1 mergeInBetween(ListNode1 list1, int a, int b, ListNode1 list2) {
        ListNode1 start = null;
        ListNode1 end = list1;

        // Set start to node a - 1 and end to node b
        for (int index = 0; index < b; index++) {
            if (index == a - 1) {
                start = end;
            }
            end = end.next;
        }
        // Connect the start node to list2
        start.next = list2;

        // Find the tail of list2
        while (list2.next != null) {
            list2 = list2.next;
        }
        // Set the tail of list2 to end.next
        list2.next = end.next;
        end.next = null;

        return list1;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedLists ob = new MergeInBetweenLinkedLists();

        // Example input
        // list1 = [10,1,13,6,9,5]
        ListNode1 list1 = new ListNode1(10);
        list1.next = new ListNode1(1);
        list1.next.next = new ListNode1(13);
        list1.next.next.next = new ListNode1(6);
        list1.next.next.next.next = new ListNode1(9);
        list1.next.next.next.next.next = new ListNode1(5);

        // list2 = [1000000,1000001,1000002]
        ListNode1 list2 = new ListNode1(1000000);
        list2.next = new ListNode1(1000001);
        list2.next.next = new ListNode1(1000002);

        int a = 3;
        int b = 4;

        // Merge list2 into list1 between nodes at indices a and b
        ListNode1 mergedList = ob.mergeInBetween(list1, a, b, list2);

        // Print the merged list for verification
        System.out.println("Merged List:");
        printList(mergedList);
    }

    // Helper method to print the linked list
    private static void printList(ListNode1 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
