import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,lst):
    if n == 6:
        print(*lst)
        return
    
    for i in range(1,N+1):
        if visited[i] == 0:
            if len(lst) == 0:
                visited[i] = 1
                dfs(n+1, lst + [num[i]])
                visited[i] = 0
            elif lst[-1] < num[i]:
                visited[i] = 1
                dfs(n+1, lst + [num[i]])
                visited[i] = 0

while True:
    num = list(map(int, input().split()))
    N = num[0]
    if N == 0:
        exit()
    visited = [0] * (N+1) 
    lst = []

    dfs(0, lst)
    print()