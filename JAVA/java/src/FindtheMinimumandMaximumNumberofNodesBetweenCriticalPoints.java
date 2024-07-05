
public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};

        // Initialize minimum distance to the maximum possible value
        int minDistance = Integer.MAX_VALUE;

        // Pointers to track the previous node, current node, and indices
        ListNode previousNode = head;
        ListNode currentNode = head.next;
        int currentIndex = 1;
        int previousCriticalIndex = -1;
        int firstCriticalIndex = -1;

        while (currentNode.next != null) {
            // Check if the current node is a local maxima or minima
            if ((currentNode.val < previousNode.val && currentNode.val < currentNode.next.val) ||
                    (currentNode.val > previousNode.val && currentNode.val > currentNode.next.val)) {

                // If this is the first critical point found
                if (previousCriticalIndex == -1) {
                    previousCriticalIndex = currentIndex;
                    firstCriticalIndex = currentIndex;
                } else {
                    // Calculate the minimum distance between critical points
                    minDistance = Math.min(minDistance, currentIndex - previousCriticalIndex);
                    previousCriticalIndex = currentIndex;
                }
            }

            // Move to the next node and update indices
            currentIndex++;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // If at least two critical points were found
        if (minDistance != Integer.MAX_VALUE) {
            int maxDistance = previousCriticalIndex - firstCriticalIndex;
            result = new int[]{minDistance, maxDistance};
        }

        return result;
    }

    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] input = {3, 1};
        ListNode head = createLinkedList(input);
        FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints solution = new FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints();
        int[] result = solution.nodesBetweenCriticalPoints(head);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

