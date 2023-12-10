import sys
input = sys.stdin.readline
from collections import deque

def bfs(x,y):
    queue.append([x,y])
    visited[x][y] = 1
    while queue:
        x,y = queue.popleft()
        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < I and 0 <= ny < I and graph[nx][ny] == 0 and visited[nx][ny] == 0:
                queue.append([nx,ny])
                graph[nx][ny] = graph[x][y] + 1
                visited[nx][ny] = 1

N = int(input())

queue = deque()
dx = [1,2,2,1,-1,-2,-2,-1]
dy = [2,1,-1,-2,-2,-1,1,2]

for i in range(N):
    I = int(input())
    startx, starty = map(int, input().split())
    endx, endy = map(int, input().split())

    graph = [[0] * I for j in range(I)]
    graph[startx][starty] = 1

    visited = [[0] * I for _ in range(I)]
    bfs(startx,starty)
    print(graph[endx][endy] - 1)