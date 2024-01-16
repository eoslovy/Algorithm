import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,sm,cnt):
    global ans
    # 종료 조건
    if n == N:
        if sm == S and cnt > 0:
            ans += 1
        return
        
    dfs(n+1, sm + lst[n], cnt + 1)  # 숫자 포함하는 경우
    dfs(n+1, sm, cnt)               # 숫자 포함하지 않는 경우


N, S = map(int, input().split())
lst = list(map(int, input().split()))
ans = 0
dfs(0, 0, 0)
print(ans)