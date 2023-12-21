import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue:
        x, y, z = queue.popleft()
        if x == N-1 and y == M-1:
            return visited[x][y][z]
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] == 1 and z == 0:
                    visited[nx][ny][1] = visited[x][y][0] + 1
                    queue.append([nx,ny,1])
                elif visited[nx][ny][z] == 0 and graph[nx][ny] == 0:
                    visited[nx][ny][z] = visited[x][y][z] + 1
                    queue.append([nx,ny,z])
    return -1

N, M = map(int, input().split())

dx = [0,0,1,-1]
dy = [1,-1,0,0]
graph = []
queue = deque()
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]

for i in range(N):
    graph.append(list(map(int, input().strip())))

queue.append([0,0,0])
visited[0][0][0] = 1
print(bfs())