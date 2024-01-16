import sys
input = sys.stdin.readline
from collections import deque

def dfs(n):
    global cnt
    if n == N:
        cnt+=1
        return
    
    for i in range(N):
        if visited1[i] == visited2[n+i] == visited3[n-i] == 0:
            visited1[i] = visited2[n+i] = visited3[n-i] = 1
            dfs(n+1)
            visited1[i] = visited2[n+i] = visited3[n-i] = 0
            
N = int(input())
cnt = 0
visited1 = [0] * N
visited2 = [0] * (2*N)
visited3 = [0] * (2*N)
dfs(0)
print(cnt)