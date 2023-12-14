import sys
input = sys.stdin.readline
from collections import deque

def bfs(x,y):
    queue.append([x,y])
    result = 0
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 1 and visited[nx][ny] == 0:
                queue.append([nx,ny])
                visited[nx][ny] = 1
                result += 1
    
    if result == 0:
        return result + 1
    else:
        return result


N = int(input())
queue = deque()
graph = []
visited = [[0] * N for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(N):
    graph.append(list(map(int, input().strip())))

cnt = 0
tmp = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1 and visited[i][j] == 0:
            tmp.append(bfs(i,j))
            cnt += 1

print(cnt)
tmp = sorted(tmp)
for i in range(cnt):
    print(tmp[i])