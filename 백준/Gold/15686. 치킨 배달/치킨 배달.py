import sys
input = sys.stdin.readline
from collections import deque

def com(start, n, tlst):
    if n == M:
        group.append(tlst)
        return
    
    for i in range(start, len(chicken)):      
        com(i+1, n+1, tlst + [chicken[i]])

def cal(tlst):
    final = 0
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 1:
                midcal = []
                for k in range(len(tlst)):
                    tmp = 0
                    if tlst[k][0] >= i:
                        tmp += tlst[k][0] - i
                    if tlst[k][0] < i:
                        tmp += i - tlst[k][0]
                    if tlst[k][1] >= j:
                        tmp += tlst[k][1] - j
                    if tlst[k][1] < j:
                        tmp += j - tlst[k][1]
                    midcal.append(tmp)
                final += min(midcal)
    return final

def dfs():
    ans = 9999999
    for i in range(len(group)):
        ans = min(ans, cal(group[i]))
    return ans

graph = []
chicken = []
group = []
N, M = map(int, input().split())

for _ in range(N):
    graph.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if graph[i][j] == 2:
            chicken.append([i,j])

com(0,0,[])
print(dfs())