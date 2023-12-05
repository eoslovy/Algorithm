import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue_f:
        x, y = queue_f.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < R and 0 <= ny < C:
                if not visited_f[nx][ny] and graph[nx][ny] != '#':
                    visited_f[nx][ny] = visited_f[x][y] + 1
                    queue_f.append([nx, ny])

    while queue_j:
        x, y = queue_j.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < R and 0 <= ny < C:
                if graph[nx][ny] != '#' and not visited_j[nx][ny]:
                    if not visited_f[nx][ny] or visited_f[nx][ny] > visited_j[x][y] + 1:
                        visited_j[nx][ny] = visited_j[x][y] + 1
                        queue_j.append([nx, ny])

            else:
                return visited_j[x][y]
    
    return "IMPOSSIBLE"

R,C = map(int, input().split())

graph = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
queue_j = deque()
queue_f = deque()

visited_j = [[0] * C for _ in range(R)]
visited_f = [[0] * C for _ in range(R)]

for _ in range(R):
    graph.append(list(map(str, input().strip())))

for i in range(R):
    for j in range(C):
        if graph[i][j] == 'J':
            queue_j.append([i,j])
            visited_j[i][j] = 1
        elif graph[i][j] == 'F':
            queue_f.append([i,j])
            visited_f[i][j] = 1

print(bfs())