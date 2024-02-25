import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

N = int(input())
place = []

for _ in range(N):
    x, y = map(int, input().split())
    place.append([x, y])

for i in sorted(place, key = lambda x : (x[0], x[1])):
    print(i[0], i[1])