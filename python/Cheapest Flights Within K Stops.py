import heapq
def findCheapestPrice(n, flights, src, dst, k):
    graph = {i: [] for i in range(n)}
    for u, v, w in flights:
        graph[u].append((v, w))

    p = [(0, src, 0)]
    visited = {}

    while p:
        price, node, stops = heapq.heappop(p)
        if node == dst:
            return price

        if stops > k:
            continue

        visited[node] = stops

        for neighb, cost in graph[node]:
            if neighb not in visited or visited[neighb] > stops:
                heapq.heappush(p, (price + cost, neighb, stops + 1))

    return -1
print(findCheapestPrice(4,[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],0,3,1))