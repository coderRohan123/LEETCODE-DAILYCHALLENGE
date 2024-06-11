def relativeSortArray( arr1, arr2):
    max_element = max(arr1)
    count = [0] * (max_element + 1)

    # Count occurrences of each element
    for element in arr1:
        count[element] += 1

    # Add elements as per relative order
    result = []
    for value in arr2:
        while count[value] > 0:
            result.append(value)
            count[value] -= 1

    # Add remaining elements in ascending order
    for num in range(max_element + 1):
        while count[num] > 0:
            result.append(num)
            count[num] -= 1

    return result
print(relativeSortArray([2,3,1,3,2,4,6,7,9,2,19], [2,1,4,3,9,6]))