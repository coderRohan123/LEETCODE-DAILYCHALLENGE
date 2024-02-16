from typing import List
from collections import Counter
def findLeastNumOfUniqueInts(arr,k):
    freq_map = Counter(arr)
    sorted_freq = sorted(freq_map.values())
    unique_count = len(sorted_freq)
    for freq in sorted_freq:
        if k >= freq:
            k -= freq
            unique_count -= 1
        else:
            break

    return unique_count
print(findLeastNumOfUniqueInts([5,5,4],1))