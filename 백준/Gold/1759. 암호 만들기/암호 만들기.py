import sys
input = sys.stdin.readline
from collections import deque
sys.setrecursionlimit(10**6)

def dfs(n, lst):
    qwe = ['a','e','i','o','u']
    cnt = 0
    if n == L:
        for i in qwe:
            for j in lst:
                if i == j:
                    cnt+=1
        if cnt != 0 and L - cnt >= 2:
            print(''.join(lst))
        return
    
    for i in range(C):
        if visited[i] == 0:
            if len(lst) == 0:
                visited[i] = 1
                dfs(n+1, lst + [graph[i]])
                visited[i] = 0
            elif lst[-1] < graph[i]:
                visited[i] = 1
                dfs(n+1, lst + [graph[i]])
                visited[i] = 0

L, C = map(int, input().split())
graph = list(map(str, input().split()))
graph.sort()
visited = [0] * C
lst = []

dfs(0, lst)