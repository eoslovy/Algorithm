import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,lst):
    if n == M:
        print(*lst)
        return

    for i in range(0, N):
        if visited[i] == 0:
            visited[i] = 1
            dfs(n+1, lst + [nums[i]])
            visited[i] = 0

N, M = map(int, input().split())
graph = list(map(int, input().split()))
nums = sorted(graph)
lst = []
visited = [0] * N

dfs(0,lst)