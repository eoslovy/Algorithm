import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue:
        a,b,c = queue.popleft()
        for i in range(6):
            nx = dx[i] + a
            ny = dy[i] + b
            nz = dz[i] + c
            if 0 <= nx < L and 0 <= ny < R and 0 <= nz < C:
                if graph[nx][ny][nz] == '.' or graph[nx][ny][nz] == 'E':
                    if visited[nx][ny][nz] == 0:
                        visited[nx][ny][nz] = visited[a][b][c] + 1
                        queue.append([nx,ny,nz])

dx = [0,0,0,0,1,-1]
dy = [0,0,1,-1,0,0]
dz = [1,-1,0,0,0,0]

while True:
    L, R, C = map(int, input().split())
    if L == 0 and R == 0 and C == 0:
        exit()
    visited = [[[0] * C for _ in range(R)] for _ in range(L)]
    queue = deque()
    graph = []

    for b in range(L):
        tmp_graph = []
        for c in range(R):
            tmp_graph.append(list(map(str, input().strip())))
        tmp = input()
        graph.append(tmp_graph)

    for a in range(L):
        for b in range(R):
            for c in range(C):
                if graph[a][b][c] == 'S':
                    queue.append([a,b,c])
                    visited[a][b][c] = 1
                elif graph[a][b][c] == 'E':
                    x,y,z = a,b,c

    bfs()
    if visited[x][y][z] != 0:
        print('Escaped in ' + str(visited[x][y][z] - 1) + ' minute(s).')
    else:print('Trapped!')