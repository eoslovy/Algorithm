import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,lst):
    if n == M:
        print(*lst)
        return

    for i in range(1, N+1):
        if visited[i] == 0:
            if len(lst) == 0:
                visited[i] = 1
                dfs(n+1, lst + [i])
                visited[i] = 0
            elif i > lst[-1]:
                visited[i] = 1
                dfs(n+1, lst + [i])
                visited[i] = 0

N, M = map(int, input().split())
visited = [0] * (N+1)
lst = []

dfs(0,lst)