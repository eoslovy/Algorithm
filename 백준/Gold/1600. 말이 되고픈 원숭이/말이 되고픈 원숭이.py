import sys
input = sys.stdin.readline
from collections import deque

def bfs(K):
    while queue:
        x,y,z = queue.popleft()
        if x == H-1 and y == W-1:
            print(visited[x][y][z] - 1)
            exit()
        for i in range(4):
            nx = ddx[i] + x
            ny = ddy[i] + y
            if 0 <= nx < H and 0 <= ny < W:
                if graph[nx][ny] == 0 and visited[nx][ny][z] == 0:
                    queue.append([nx,ny,z])
                    visited[nx][ny][z] = visited[x][y][z] + 1
        if z < K:
            for i in range(8):
                nx = dx[i] + x
                ny = dy[i] + y
                if 0 <= nx < H and 0 <= ny < W:
                    if graph[nx][ny] == 0 and visited[nx][ny][z+1] == 0:
                        queue.append([nx,ny,z+1])
                        visited[nx][ny][z+1] = visited[x][y][z] + 1
        z += 1
    return print(-1)

K = int(input())
W, H = map(int, input().split())

graph = []
visited = [[[0] * (K+1) for _ in range(W)] for _ in range(H)]
queue = deque()
dx = [1,2,2,1,-1,-2,-2,-1]
dy = [2,1,-1,-2,-2,-1,1,2]
ddx = [0,0,1,-1]
ddy = [1,-1,0,0]

for _ in range(H):
    graph.append(list(map(int, input().split())))

queue.append([0,0,0])
visited[0][0][0] = 1
    
bfs(K)