from itertools import zip_longest


def compareVersion(v1, v2):
    # Split version strings and convert each part to integers
    v1_parts = list(map(int, v1.split('.')))
    v2_parts = list(map(int, v2.split('.')))

    # Compare version parts while considering potential differences in length
    for rev1, rev2 in zip_longest(v1_parts, v2_parts, fillvalue=0):
        if rev1 == rev2:
            continue
        return -1 if rev1 < rev2 else 1

    # If all parts are equal, versions are identical
    return 0


# Test the function
print(compareVersion("1.0", "1.0.0"))
