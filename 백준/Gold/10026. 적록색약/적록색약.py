import sys
input = sys.stdin.readline
from collections import deque

def rbfs(x,y):
    queue.append([x,y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < T and 0 <= ny < T and graph[nx][ny] == 'R' and visited[nx][ny] == 0:
                queue.append([nx,ny])
                visited[nx][ny] = 1

def gbfs(x,y):
    queue.append([x,y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < T and 0 <= ny < T and graph[nx][ny] == 'G' and visited[nx][ny] == 0:
                queue.append([nx,ny])
                visited[nx][ny] = 1                

def bbfs(x,y):
    queue.append([x,y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < T and 0 <= ny < T and graph[nx][ny] == 'B' and visited[nx][ny] == 0:
                queue.append([nx,ny])
                visited[nx][ny] = 1
                
def rgbfs(x,y):
    queue.append([x,y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < T and 0 <= ny < T and visited[nx][ny] == 0:
                if graph[nx][ny] == 'R' or graph[nx][ny] == 'G':
                    queue.append([nx,ny])
                    visited[nx][ny] = 1

T = int(input())

queue = deque()
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

graph = []

for i in range(T):
    graph.append(list(map(str, input().strip())))

visited = [[0] * T for _ in range(T)]

cnt1 = 0
for i in range(T):
    for j in range(T):
        if graph[i][j] == 'R' and visited[i][j] == 0:
            rbfs(i,j)
            cnt1 += 1
        elif graph[i][j] == 'G' and visited[i][j] == 0:
            gbfs(i,j)
            cnt1 += 1
        elif graph[i][j] == 'B' and visited[i][j] == 0:
            bbfs(i,j)
            cnt1 += 1

print(cnt1)

visited = [[0] * T for _ in range(T)]
cnt2 = 0
for i in range(T):
    for j in range(T):
        if visited[i][j] == 0:
            if graph[i][j] == 'R' or graph[i][j] == 'G':
                rgbfs(i,j)
                cnt2 += 1
            elif graph[i][j] == 'B':
                bbfs(i,j)
                cnt2 += 1

print(cnt2)