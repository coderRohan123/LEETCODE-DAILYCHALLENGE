import java.util.ArrayList;
import java.util.Arrays;

class Tree12 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // build graph and declare results
        final ArrayList<Integer>[] graph = new ArrayList[n];
        final int[] count = new int[n];
        Arrays.fill(count, 1);
        final int[] answer = new int[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        postOrder(0, -1, graph, count, answer);
        // after postOrder, only answer[root] is correct, so do preOrder to update answer
        preOrder(0, -1, graph, count, answer, n);

        return answer;
    }

    // set count et subTreeSum, here use answer[]
    private void postOrder(int node, int parent, ArrayList<Integer>[] graph, int[] count, int[] answer) {
        for (int child : graph[node]) {
            if (child != parent) {
                postOrder(child, node, graph, count, answer);
                count[node] += count[child];
                answer[node] += answer[child] + count[child];
            }
        }
    }

    private void preOrder(int node, int parent, ArrayList<Integer>[] graph, int[] count, int[] answer, int n) {
        for (int child : graph[node]) {
            if (child != parent) {
                answer[child] = answer[node] + (n - count[child]) - count[child];
                preOrder(child, node, graph, count, answer, n);
            }
        }
    }
}

public class SumofDistanceinTree {
    public static void main(String[] args) {
        Tree12 tree = new Tree12();
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] result = tree.sumOfDistancesInTree(n, edges);
        System.out.println("Input edges:");
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
        System.out.println("Result: " + Arrays.toString(result));
    }
}

