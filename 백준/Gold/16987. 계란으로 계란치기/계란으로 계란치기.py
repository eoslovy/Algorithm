import sys
input = sys.stdin.readline
from collections import deque

def dfs(n,cnt):
    global ans
    if n == N:
        ans = max(ans, cnt)
        return
    
    if armor[n] <= 0:       # 계란이 깨지면
        dfs(n+1, cnt)       # 다음 계란으로 패스
    else:
        flag = False        # 한 번도 안 부딪혀도 다음 계란으로 가야함
        for i in range(N):  # 하나씩 깸
            if n == i or armor[i] <= 0:
                continue
            flag = True
            armor[n] -= weight[i]
            armor[i] -= weight[n]
            dfs(n+1, cnt + int(armor[n]<=0) + int(armor[i]<=0))
            armor[n] += weight[i]
            armor[i] += weight[n]
        if flag == False:
            dfs(n+1, cnt)

armor = []
weight = []

N = int(input())

for _ in range(N):
    a, b = map(int, input().split())
    armor.append(a)
    weight.append(b)

ans = 0
# 계란 index, 깨진 계란 개수
dfs(0,0)
print(ans)