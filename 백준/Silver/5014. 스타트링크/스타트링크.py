import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while queue:
        y = queue.popleft()
        for i in range(2):
            ny = dy[i] + y
            if 0 <= ny < F and visited[ny] == 0:
                visited[ny] = visited[y] + 1
                queue.append(ny)

F, S, G, U, D = map(int, input().split())

dy = [U, -D]
queue = deque()

visited = [0] * F

visited[S-1] = 1
queue.append(S-1)
bfs()

if S == G:
    print(0)
else:
    if visited[G-1] == 0:
        print('use the stairs')
        exit()
    else: print(visited[G-1]-1)