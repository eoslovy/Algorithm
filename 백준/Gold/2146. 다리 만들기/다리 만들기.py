import sys
input = sys.stdin.readline
from collections import deque

def bfs(x,y):
    queue = deque()
    queue.append([x,y])
    visited[x][y] = True
    graph[x][y] = mark
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if graph[nx][ny] == 1:
                    queue.append([nx,ny])
                    graph[nx][ny] = mark
                    visited[nx][ny] = True

def bfs2(island):
    queue = deque()
    dist = [[-1]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if graph[i][j] == island:
                queue.append([i,j])
                dist[i][j] == 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < N:
                if graph[nx][ny] != island and graph[nx][ny] != 0:
                    return dist[x][y]
                if graph[nx][ny] == 0 and dist[nx][ny] == -1:
                    dist[nx][ny] = dist[x][y] + 1
                    queue.append([nx,ny])
                

N = int(input())
graph = []
visited = [[False]*N for _ in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]

for _ in range(N):
    graph.append(list(map(int, input().split())))

mark = 1
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1 and not visited[i][j]:
            bfs(i,j)
            mark += 1

result = sys.maxsize
for island in range(1, mark):
    result = min(result, bfs2(island))

print(result+1)