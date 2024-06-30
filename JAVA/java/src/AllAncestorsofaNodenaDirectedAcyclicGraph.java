import java.util.*;

public class AllAncestorsofaNodenaDirectedAcyclicGraph {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create adjacency list
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Fill the adjacency list and indegree array based on the edges
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
            indegree[to]++;
        }

        // Queue for nodes with no incoming edges (starting points for topological sort)
        Queue<Integer> nodesWithZeroIndegree = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                nodesWithZeroIndegree.add(i);
            }
        }

        // List to store the topological order of nodes
        List<Integer> topologicalOrder = new ArrayList<>();
        while (!nodesWithZeroIndegree.isEmpty()) {
            int currentNode = nodesWithZeroIndegree.poll();
            topologicalOrder.add(currentNode);

            // Reduce indegree of neighboring nodes and add them to the queue
            // if they have no more incoming edges
            for (int neighbor : adjacencyList[currentNode]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    nodesWithZeroIndegree.add(neighbor);
                }
            }
        }

        // Initialize the result list and set list for storing ancestors
        List<List<Integer>> ancestorsList = new ArrayList<>();
        List<Set<Integer>> ancestorsSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<>());
            ancestorsSetList.add(new HashSet<>());
        }

        // Fill the set list with ancestors using the topological order
        for (int node : topologicalOrder) {
            for (int neighbor : adjacencyList[node]) {
                // Add immediate parent, and other ancestors.
                ancestorsSetList.get(neighbor).add(node);
                ancestorsSetList
                        .get(neighbor)
                        .addAll(ancestorsSetList.get(node));
            }
        }

        // Convert sets to lists and sort them
        for (int i = 0; i < ancestorsList.size(); i++) {
            ancestorsList.get(i).addAll(ancestorsSetList.get(i));
            Collections.sort(ancestorsList.get(i));
        }

        return ancestorsList;
    }

    public static void main(String[] args) {
        System.out.println(getAncestors(5,new int[][] {{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}))
;
    }
}
