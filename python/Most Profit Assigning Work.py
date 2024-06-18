def maxProfitAssignment(
        difficulty, profit, worker
) -> int:
    # Find maximum ability in the worker array.

    maxAbility = max(worker)
    jobs = [0] * (maxAbility + 1)

    for i in range(len(difficulty)):
        if difficulty[i] <= maxAbility:
            jobs[difficulty[i]] = max(jobs[difficulty[i]], profit[i])
    # Take maxima of prefixes.

    for i in range(1, maxAbility + 1):
        jobs[i] = max(jobs[i], jobs[i - 1])
    netProfit = 0
    for ability in worker:
        netProfit += jobs[ability]
    return netProfit
print(maxProfitAssignment( [85,47,57],  [24,66,99], [40,25,25]))