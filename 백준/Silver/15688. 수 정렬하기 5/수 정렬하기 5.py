import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

N = int(input())
nums = []

for i in range(N):
    nums.append(int(input()))

nums = sorted(nums)
for i in range(N):
    print(nums[i])