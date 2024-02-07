def frequencySort(s):
    book = {}

    for i in s:
        if i in book:
            book[i] += 1
        else:
            book[i] = 1
    res = sorted(book.items(), key=lambda k: k[1], reverse=True)

    return ''.join([i[0] * i[1] for i in res])
print(frequencySort("tree"))