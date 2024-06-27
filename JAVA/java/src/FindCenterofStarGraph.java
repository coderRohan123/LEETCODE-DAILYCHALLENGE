import java.util.List;

public class FindCenterofStarGraph {
    public static int findCenter(List<List<Integer>> edges) {
        int[] firstEdge = new int[] { edges.get(0).get(0), edges.get(0).get(1) };
        int[] secondEdge = new int[] { edges.get(1).get(0), edges.get(1).get(1) };

        return firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1] ? firstEdge[0] : firstEdge[1];
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
                List.of(1, 2),
                List.of(2, 3),
                List.of(4, 2)
        );

        int center = findCenter(edges);
        System.out.println(center);  // Output should be 2
    }
}

