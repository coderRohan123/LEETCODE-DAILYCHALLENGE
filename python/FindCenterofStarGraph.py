from typing import List

def findCenter(edges: List[List[int]]) -> int:
    first_edge, second_edge = edges[0], edges[1]
    return first_edge[0] if first_edge[0] in second_edge else first_edge[1]

# Example usage:
edges =  [[1,2],[2,3],[4,2]]
center = findCenter(edges)
print(center)  # Output should be 2
