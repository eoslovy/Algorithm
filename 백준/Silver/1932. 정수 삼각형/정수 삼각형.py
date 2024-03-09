import sys
input = sys.stdin.readline

n = int(input())
graph = []
result = [[0]*n for _ in range(n)]
for i in range(n):
    graph.append(list(map(int, input().split())))

result[0][0] = graph[0][0]
if n == 1:
    print(graph[0][0])
    exit()

result[1][0] = graph[0][0]+graph[1][0]
result[1][1] = graph[0][0]+graph[1][1]

for i in range(2,n):
    for j in range(i+1):
        if j == 0:
            result[i][j] = result[i-1][j]+ graph[i][j]
        elif j == i:
            result[i][j] = result[i-1][j-1]+ graph[i][j]
        else:
            result[i][j] = max(result[i-1][j-1], result[i-1][j]) + graph[i][j]

print(max(max(result)))