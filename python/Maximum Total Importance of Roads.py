
def maximumImportance(n: int, roads) -> int:
    degree = [0] * n

    for edge in roads:
        degree[edge[0]] += 1
        degree[edge[1]] += 1

    degree.sort()

    value = 1
    total_importance = 0
    for d in degree:
        total_importance += value * d
        value += 1

    return total_importance
print(maximumImportance( 5,  [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]))