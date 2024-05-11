import heapq
def mincostToHireWorkers(quality,wage,k):
    n = len(quality)
    total_cost = float("inf")
    current_total_quality = 0
    wage_to_quality_ratio = []

    # Calculate wage-to-quality ratio for each worker
    for i in range(n):
        wage_to_quality_ratio.append((wage[i] / quality[i], quality[i]))

    # Sort workers based on their wage-to-quality ratio
    wage_to_quality_ratio.sort(key=lambda x: x[0])

    # Use a heap to keep track of the highest quality workers
    highest_quality_workers = []

    # Iterate through workers
    for i in range(n):
        heapq.heappush(highest_quality_workers, -wage_to_quality_ratio[i][1])
        current_total_quality += wage_to_quality_ratio[i][1]

        # If we have more than k workers,
        # remove the one with the highest quality
        if len(highest_quality_workers) > k:
            current_total_quality += heapq.heappop(highest_quality_workers)

        # If we have exactly k workers,
        # calculate the total cost and update if it's the minimum
        if len(highest_quality_workers) == k:
            total_cost = min(
                total_cost, current_total_quality * wage_to_quality_ratio[i][0]
            )

    return total_cost
print(mincostToHireWorkers([10,20,5], [70,50,30],  2))
'''
There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

Every worker in the paid group must be paid at least their minimum wage expectation.
In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.'''