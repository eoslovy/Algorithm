import sys
input = sys.stdin.readline
from collections import deque
sys.setrecursionlimit(10**6)

def cal(tlst):
    v = [[0]*M for _ in range(N)]

    # 모든 CCTV에 대해서 처리(좌표, type, rot)
    for i in range(CNT):
        x, y = lst[i]       # 0~N-1, 0~M-1
        rot = tlst[i]       # 0~3
        type = graph[x][y]  # 1~5

        # type에 따른 모든 방향을 뻗어가면서 v[]에 1 표시
        for dr in cctv[type]:
            dr = (dr+rot)%4
            nx, ny = x, y
            while True:
                nx, ny = nx + dx[dr], ny + dy[dr]
                if 0 > nx or nx >= N:
                    break
                if 0 > ny or ny >= M:
                    break
                if graph[nx][ny] == 6:  # 벽이면 멈춤
                    break
                v[nx][ny] = 1

    # 사각지대 개수 카운트
    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0 and v[i][j] == 0:
                cnt+=1
    return cnt


def dfs(n, tlst):
    global ans
    if n == CNT:    # 모든 CCTV 방향(0~3) 정하기 완료
        ans = min(ans, cal(tlst))
        return

    dfs(n+1, tlst+[0])  #   0도 회전
    dfs(n+1, tlst+[1])  #  90도 회전
    dfs(n+1, tlst+[2])  # 180도 회전
    dfs(n+1, tlst+[3])  # 270도 회전


N, M = map(int, input().split())

graph = []
# 1번 ~ 5번 CCTV 저장
lst = []
dx = [-1,0,1,0]
dy = [0,1,0,-1]
cctv = [[], [1], [1,3], [0,1], [0,1,3], [0,1,2,3]]
ans = M*N

for _ in range(N):
    graph.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if 1<=graph[i][j]<=5:
            lst.append([i,j])

CNT = len(lst)
dfs(0,[])
print(ans)