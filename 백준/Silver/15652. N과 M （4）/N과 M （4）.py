import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,lst):
    if n == M:
        print(*lst)
        return

    for i in range(1, N+1):
        if len(lst) == 0:
            visited[i] = 1
            dfs(n+1, lst + [i])
        elif lst[-1] <= i:
            visited[i] = 1
            dfs(n+1, lst + [i])

N, M = map(int, input().split())
lst = []
visited = [0] * (N+1)

dfs(0,lst)