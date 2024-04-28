class Tree12:
    def sumOfDistancesInTree(self, n, edges):
        # build graph and declare results
        graph = [[] for _ in range(n)]
        count = [1] * n
        answer = [0] * n

        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        self.postOrder(0, -1, graph, count, answer)
        # after postOrder, only answer[root] is correct, so do preOrder to update answer
        self.preOrder(0, -1, graph, count, answer, n)

        return answer

    # set count et subTreeSum, here use answer[]
    def postOrder(self, node, parent, graph, count, answer):
        for child in graph[node]:
            if child != parent:
                self.postOrder(child, node, graph, count, answer)
                count[node] += count[child]
                answer[node] += answer[child] + count[child]

    def preOrder(self, node, parent, graph, count, answer, n):
        for child in graph[node]:
            if child != parent:
                answer[child] = answer[node] + (n - count[child]) - count[child]
                self.preOrder(child, node, graph, count, answer, n)

if __name__ == "__main__":
    tree = Tree12()
    n = 6
    edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
    result = tree.sumOfDistancesInTree(n, edges)
    print("Input edges:")
    for edge in edges:
        print(edge)
    print("Result:", result)
'''
834. Sum of Distances in Tree
Hard

5270

120

Add to List

Share
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.'''