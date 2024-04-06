import sys
input = sys.stdin.readline

def dfs(start, end):
    graph[start][end] = 1
    for i in lst:
        if i[0] == end and graph[start][i[1]]==0:
            dfs(start,i[1])

n = int(input())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

lst = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            lst.append([i,j])

for i in lst:
    dfs(i[0],i[1])

for i in range(n):
    print(*graph[i])