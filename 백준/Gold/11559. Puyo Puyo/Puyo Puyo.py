import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

def move():
    for i in range(6):
        for j in range(11, -1, -1):  # 바닥부터 위로 검사
            if graph[j][i] == '.':
                for k in range(j-1, -1, -1):  # 현재 위치보다 위에 있는 블록 검사
                    if graph[k][i] != '.':
                        graph[j][i] = graph[k][i]  # 블록 이동
                        graph[k][i] = '.'  # 이동한 블록 위치 초기화
                        break

def bfs(x,y):
    flag = False
    cnt = 1
    queue.append([x,y])
    visited = [[0]*6 for _ in range(12)]
    visited[x][y] = 1
    remove_queue = [[x,y]]
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 12 and 0 <= ny < 6:
                if visited[nx][ny] == 0:
                    if graph[nx][ny] == graph[x][y]:
                        visited[nx][ny] = 1
                        queue.append([nx,ny])
                        remove_queue.append([nx,ny])
                        cnt+=1

    if cnt >= 4:
        flag = True
    return flag, remove_queue

def cal():
    ans = 0
    while True:
        visited = [[0] * 6 for _ in range(12)]
        remove = False
        for i in range(12):
            for j in range(6):
                if graph[i][j] != '.' and not visited[i][j]:
                    flag, remove_queue = bfs(i,j)
                    if flag:
                        remove = True
                        for x,y in remove_queue:
                            graph[x][y] = '.'

        if not remove:
            print(ans)
            return      
                      
        move()
        ans += 1
        

dx = [0,0,1,-1]
dy = [1,-1,0,0]

visited = [[0]*6 for _ in range(12)]
queue = deque()
graph = []
trans = []
for _ in range(12):
    graph.append(list(map(str, input().strip())))

cal()