import heapq
def kthSmallestPrimeFraction(arr, k):
    # Create a priority queue to store pairs of fractions
    pq = []

    # Custom comparator for priority queue
    def compare(a, b):
        return a[0] - b[0]

    # Push the fractions formed by dividing each element by
    # the largest element into the priority queue
    for i in range(len(arr)):
        heapq.heappush(pq, ((arr[i] / arr[-1]), i, len(arr) - 1))

    # Iteratively remove the top element (smallest fraction)
    # and replace it with the next smallest fraction
    for _ in range(k - 1):
        cur = heapq.heappop(pq)
        numerator_index = cur[1]
        denominator_index = cur[2] - 1
        if denominator_index > numerator_index:
            heapq.heappush(pq, (
                (arr[numerator_index] / arr[denominator_index]),
                numerator_index,
                denominator_index
            ))

    # Retrieve the kth smallest fraction from
    # the top of the priority queue
    result = heapq.heappop(pq)
    return [arr[result[1]], arr[result[2]]]
print(kthSmallestPrimeFraction( [1,2,3,5], 3))
'''
You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].

Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].

 

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation: The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5.
Example 2:

Input: arr = [1,7], k = 1
Output: [1,7]
 

Constraints:

2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 104
arr[0] == 1
arr[i] is a prime number for i > 0.
All the numbers of arr are unique and sorted in strictly increasing order.
1 <= k <= arr.length * (arr.length - 1) / 2'''