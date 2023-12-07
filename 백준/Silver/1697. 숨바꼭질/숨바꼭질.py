import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue:
        x = queue.popleft()
        if x == K:
            print(visited[x])
            break
        for i in range(2):
            for nx in (x-1, x+1, x*2):
                if 0 <= nx <= max(N, K) * 2 and visited[nx] == 0:
                    queue.append(nx)
                    visited[nx] = visited[x] + 1


queue = deque()
N, K = list(map(int, input().split()))

visited = [0] * (max(N,K) * 2 + 1)

queue.append(N)
bfs()