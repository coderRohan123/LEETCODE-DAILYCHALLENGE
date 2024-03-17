def insert(intervals, newInterval):
    # If the intervals vector is empty, return a vector containing the newInterval
    if not intervals:
        return [newInterval]

    n = len(intervals)
    target = newInterval[0]
    left, right = 0, n - 1

    # Binary search to find the position to insert newInterval
    while left <= right:
        mid = (left + right) // 2
        if intervals[mid][0] < target:
            left = mid + 1
        else:
            right = mid - 1

    # Insert newInterval at the found position
    intervals.insert(left, newInterval)

    # Merge overlapping intervals
    res = []
    for interval in intervals:
        # If res is empty or there is no overlap, add the interval to the result
        if not res or res[-1][1] < interval[0]:
            res.append(interval)
        # If there is an overlap, merge the intervals by updating the end of the last interval in res
        else:
            res[-1][1] = max(res[-1][1], interval[1])
    return res
print(insert([[1,3],[6,9]],  [2,5]))







































































'''
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
'''