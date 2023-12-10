import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue:
        x, y, z = queue.popleft()
        for i in range(6):
            nx = dx[i] + x
            ny = dy[i] + y
            nz = dz[i] + z
            if 0 <= nx < H and 0 <= ny < N and 0 <= nz < M and graph[nx][ny][nz] == 0 and visited[nx][ny][nz] == 0:
                queue.append([nx, ny, nz])
                visited[nx][ny][nz] = 1
                graph[nx][ny][nz] = graph[x][y][z] + 1


M, N, H = list(map(int, input().split()))

queue = deque()
dx = [0, 0, 1, -1, 0, 0]
dy = [0, 0, 0, 0, 1, -1]
dz = [1, -1, 0, 0, 0, 0]

graph = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

visited = [[[0] * M for _ in range(N)] for _ in range(H)]

for a in range(H):
    for b in range(N):
        for c in range(M):
            if graph[a][b][c] == 1 and visited[a][b][c] == 0:
                queue.append([a,b,c])
                visited[a][b][c] = 1

bfs()

answer = 0
for i in graph:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit()
        answer = max(answer, max(j))

print(answer-1)