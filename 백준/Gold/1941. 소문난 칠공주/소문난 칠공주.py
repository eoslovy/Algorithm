import sys
input = sys.stdin.readline
from collections import deque
sys.setrecursionlimit(10**6)

def bfs(x,y):
    queue.append([x,y])
    v = [[0]*5 for _ in range(5)]
    v[x][y] = 1
    cnt = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < 5 and 0 <= ny < 5:
                if v[nx][ny] == 0 and visited[nx][ny] == 1:
                    queue.append([nx,ny])
                    v[nx][ny] = 1
                    cnt += 1
    return cnt == 7
                    
def check():
    for i in range(5):
        for j in range(5):
            if visited[i][j] == 1:
                return bfs(i,j)

def dfs(n,cnt,scnt):
    global ans
    if cnt > 7:
        return
    
    if n == 25:
        if cnt == 7 and scnt >= 4:  #7명 그룹이고, 4명이 다솜파이면
            if check():             #인접했는지 체크
                ans+=1
        return
    
    visited[n//5][n%5] = 1          # 포함하는 경우
    dfs(n+1, cnt+1, scnt+int(graph[n//5][n%5]=='S'))
    visited[n//5][n%5] = 0          # 원상복구
    dfs(n+1, cnt, scnt)             # 포함 x

graph = []
ans = 0
queue = deque()
dx = [0,0,1,-1]
dy = [1,-1,0,0]
visited = [[0]*5 for _ in range(5)]

for _ in range(5):
    graph.append(list(map(str, input().strip())))
# 학생번호 (0~24), 포함 학생 수, 다솜파 학생 수
dfs(0,0,0)
print(ans)