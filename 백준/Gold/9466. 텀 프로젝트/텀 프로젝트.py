import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import deque

def dfs(x):
    global result
    visited[x] = 1
    cycle.append(x)
    number = numbers[x]

    if visited[number] == 1:
        if number in cycle:
            result += cycle[cycle.index(number):]
        return
    else:
        dfs(number)

T = int(input())

for _ in range(T):
    N = int(input())
    numbers = [0] + list(map(int, input().split()))
    visited = [1] + [0] * N
    result = []

    for i in range(1, N+1):
        if visited[i] == 0:
            cycle = []
            dfs(i)
        
    print(N - len(result))