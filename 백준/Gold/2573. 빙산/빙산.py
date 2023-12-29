import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] > 0:
                    graph[nx][ny] -= 1

def tmp_bfs():
    while tmp_queue:
        x,y = tmp_queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] > 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    tmp_queue.append([nx,ny])

N, M = map(int, input().split())

dx = [0,0,1,-1]
dy = [1,-1,0,0]
graph = []
queue = deque()
tmp_queue = deque()

for _ in range(N):
    graph.append(list(map(int, input().split())))

cnt = 1
tmp = 0
while cnt == 1:
    visited = [[0] * M for _ in range(N)]
    tmp += 1
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                queue.append([i,j])
    bfs()

    for i in range(N):
        for j in range(M):
            if graph[i][j] > 0 and visited[i][j] == 0:
                tmp_queue.append([i,j])
                visited[i][j] = 1
                tmp_bfs()
                cnt += 1
    cnt -= 1

    graph_max = 0
    for i in range(N):
        if max(graph[i]) > graph_max:
            graph_max = max(graph[i])

    if graph_max == 0:
        print(0)
        exit()

print(tmp)