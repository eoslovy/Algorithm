import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,lst):
    if n == M:
        print(*lst)
        return

    for i in range(1, N+1):
        dfs(n+1, lst + [i])

N, M = map(int, input().split())
lst = []

dfs(0,lst)