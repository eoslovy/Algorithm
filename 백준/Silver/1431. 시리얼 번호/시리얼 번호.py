import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

N = int(input())

nums = []

for _ in range(N):
    cnt = 0
    a = str(input())
    b = len(a)
    tmp = list(a.strip())
    for i in range(len(tmp)):
        if 'A' <= tmp[i] <= 'Z':
            continue
        elif 0 <= int(tmp[i]) <= 9:
            cnt += int(tmp[i])
    nums.append([a.strip(),b,cnt])

for i in sorted(nums, key = lambda x : (x[1], x[2], x[0])):
    print(i[0])
