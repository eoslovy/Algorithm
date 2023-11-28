import sys
input = sys.stdin.readline
from collections import deque

def bfs(x,y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    q = deque()
    q.append([x,y])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
                q.append([nx, ny])
                graph[nx][ny] = graph[x][y] + 1
   
    return graph[N-1][M-1]

N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().strip())))

print(bfs(0,0))