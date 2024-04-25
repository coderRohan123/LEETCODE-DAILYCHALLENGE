import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        // Create graph using adjacency list
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Initialize leaves set with nodes that have only one neighbor
        Deque<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        // Iteratively remove leaves until MHTs' roots remain
        while (n > 2) {
            n -= leaves.size();
            Deque<Integer> newLeaves = new LinkedList<>();
            while (!leaves.isEmpty()) {
                int leaf = leaves.poll();
                int neighbor = graph.get(leaf).iterator().next(); // Get the only neighbor
                graph.get(neighbor).remove(leaf); // Remove the leaf from its neighbor's neighbors
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.offer(neighbor);
                }
            }
            leaves = newLeaves;
        }

        result.addAll(leaves);
        return result;
    }

    public static void main(String[] args) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(mht.findMinHeightTrees(n, edges));
    }
}

