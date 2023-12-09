import sys
input = sys.stdin.readline
from collections import deque

def bfs(x,y):
    queue.append([x,y])
    cnt = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1 and visited[nx][ny] == 0:
                queue.append([nx,ny])
                visited[nx][ny] = 1
    return cnt


T = int(input())

queue = deque()
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(T):
    M, N, K = list(map(int, input().split()))
    graph = [[0] * M for _ in range(N)]

    for j in range(K):
        X, Y = list(map(int, input().split()))
        graph[Y][X] = 1

    visited = [[0] * M for _ in range(N)]

    result = 0
    for a in range(M):
        for b in range(N):
            if graph[b][a] == 1 and visited[b][a] == 0:
                result += bfs(b,a)
    
    print(result)