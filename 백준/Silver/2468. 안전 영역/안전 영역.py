import sys
input = sys.stdin.readline
from collections import deque

def bfs(k):
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0 and graph[nx][ny] > k:
                visited[nx][ny] = visited[x][y] + 1
                queue.append([nx,ny])

N = int(input())
graph = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(N):
    graph.append(list(map(int, input().split())))

cnt = [0] * 100
min_num = 101
max_num = 0
for i in range(N):
    if min(graph[i]) < min_num:
        min_num = min(graph[i])
    if max(graph[i]) > max_num:
        max_num = max(graph[i])

for i in range(min_num):
    cnt[i] = 1

for i in range(min_num, max_num, 1):
    visited = [[0] * N for _ in range(N)]
    queue = deque()
    for a in range(N):
        for b in range(N):
            if graph[a][b] > i and visited[a][b] == 0:
                queue.append([a,b])
                bfs(i)
                cnt[i] += 1

print(max(cnt))