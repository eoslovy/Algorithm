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
            if 0 <= nx < M and 0 <= ny < N and visited[nx][ny] == 0:
                queue.append([nx,ny])
                visited[nx][ny] = 1
                result += 1
    if result == 0:
        return result + 1
    else:
        return result


M, N, K = map(int, input().split())
queue = deque()
visited = [[0] * N for _ in range(M)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for _ in range(K):
    a, b, c, d = map(int, input().split())


    for i in range(b, d, 1):
        for j in range(a, c, 1):
            visited[i][j] = 1

cnt = 0
tmp = []
for i in range(M):
    for j in range(N):
        if visited[i][j] == 0:
            tmp.append(bfs(i,j))
            cnt += 1

print(cnt)
tmp = sorted(tmp)
print(*tmp)