from bisect import bisect_left

def LIS(nums):
    # dp는 각 길이를 달성하는 마지막 원소의 최소값을 저장합니다.
    dp = []
    # prev_index는 각 원소가 가리키는 이전 원소의 인덱스를 저장합니다.
    prev_index = [-float('inf')] * n
    # path는 LIS를 구성하는 실제 인덱스를 저장합니다.
    path = []

    for i in range(n):
        # 현재 원소가 dp 배열에 추가되어야 할 위치를 찾습니다.
        pos = bisect_left(dp, nums[i])
        # pos가 dp 배열의 크기와 같다면, 새로운 원소를 추가합니다.
        if pos == len(dp):
            dp.append(nums[i])
        else:
            dp[pos] = nums[i]
        # pos가 0보다 크면, 현재 원소의 이전 원소 인덱스를 저장합니다.
        if pos > 0:
            prev_index[i] = path[pos-1]
        # path 배열을 업데이트 합니다.
        if pos == len(path):
            path.append(i)
        else:
            path[pos] = i

    # LIS를 복원합니다.
    lst = []
    k = path[-1]
    while k != -float('inf'):
        lst.append(nums[k])
        k = prev_index[k]
    lst.reverse()

    return lst

n = int(input())
nums = list(map(int, input().split()))

lst = LIS(nums)

print(len(lst))
print(*lst)