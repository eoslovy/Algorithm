import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

tmp = list(map(int, input().split()))

nums = []
for i in range(len(tmp) - 1):
    nums.append(int(tmp[i+1]))

N = int(tmp[0])
cnt  = int(tmp[0]) - len(tmp) + 1

tmp_nums = []
while cnt != 0:
    tmp_nums = list(map(int, input().split()))
    cnt -= len(tmp_nums)
    for i in range(len(tmp_nums)):
        nums.append(tmp_nums[i])

real = []
for i in range(N):
    flag = 0
    while nums[i] != 0:
        a = nums[i] % 10
        if flag != 0 or a != 0:
            flag *= 10
            flag += a
        nums[i]//=10
    real.append(flag)

for i in sorted(real):
    print(i)