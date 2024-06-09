def subarraysDivByK(nums, k: int) -> int:
    count = 0  # Initialize variable to keep track of count
    sm = 0  # Initialize variable to keep track of running sum
    mod = 0  # Initialize variable to store remainder
    mp = {}  # Initialize dictionary to keep track of the number of occurrences of each remainder
    mp[mod] = 1  # Initial remainder is 0
    for i in range(len(nums)):
        sm += nums[i]  # Update running sum
        mod = sm % k  # Update remainder
        if mod < 0:
            mod += k  # If remainder is negative, add k to make it positive
        if mod in mp:
            count += mp[
                mod]  # If remainder is already present in dictionary, add the number of occurrences of that remainder to the count
            mp[mod] += 1  # Increment the count for that remainder in the dictionary
        else:
            mp[mod] = 1  # If remainder is not present in the dictionary, add it with a count of 1
    return count
print(subarraysDivByK( [4,5,0,-2,-3,1], 5))