import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue_f:
        x, y = queue_f.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] != '#' and visited_f[nx][ny] == 0:
                visited_f[nx][ny] = visited_f[x][y] + 1
                queue_f.append([nx,ny])

    while queue_s:
        x, y = queue_s.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < h and 0 <= ny < w:
                if graph[nx][ny] != '#' and visited_s[nx][ny] == 0:
                    if visited_f[nx][ny] == 0 or visited_s[x][y] + 1 < visited_f[nx][ny]:
                        visited_s[nx][ny] = visited_s[x][y] + 1
                        queue_s.append([nx,ny])
            else:
                return visited_s[x][y]
    return 'IMPOSSIBLE'
            
N = int(input())
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for _ in range(N):
    w,h = map(int, input().split())
    graph = []
    queue_s = deque()
    queue_f = deque()
    visited_s = [[0] * w for _ in range(h)]    
    visited_f = [[0] * w for _ in range(h)]

    for _ in range(h):
        graph.append(list(map(str, input().strip())))
    
    for i in range(h):
        for j in range(w):
            if graph[i][j] == '*':
                queue_f.append([i,j])
                visited_f[i][j] = 1
            elif graph[i][j] == '@':
                queue_s.append([i,j])
                visited_s[i][j] = 1

    print(bfs())