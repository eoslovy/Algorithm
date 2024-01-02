import sys
input = sys.stdin.readline
from collections import deque

def bfs(x):
    flag = [0] * 2 * max(N,K)
    queue.append(x)
    visited[x] = 1
    while queue:
        x = queue.popleft()
        if x == K:
            print(visited[K] - flag[K] - 1)
            exit()
        for i in [2*x, x-1, x+1]:
            if 0 <= i < 2*(max(N,K)) and visited[i] == 0:
                if i == 2*x:
                    queue.append(i)
                    visited[i] = visited[x] + 1
                    flag[i] = flag[x] + 1
                elif i == x-1 or i == x+1:
                    queue.append(i)
                    visited[i] = visited[x] + 1
                    flag[i] = flag[x]

queue = deque()
N, K = map(int, input().split())
visited = [0] * 2 * max(N,K)

if N == K:
    print(0)
    exit()
bfs(N)
