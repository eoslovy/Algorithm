import sys
input = sys.stdin.readline

def dfs(x, y, dir):
    global result
    if x == n - 1 and y == n - 1:
        result += 1
        return

    # 가로
    if dir == 0 or dir == 2:
        if y + 1 < n and graph[x][y + 1] == 0:
            dfs(x, y + 1, 0)

    # 세로
    if dir == 1 or dir == 2:
        if x + 1 < n and graph[x + 1][y] == 0:
            dfs(x + 1, y, 1)

    # 대각선
    if x + 1 < n and y + 1 < n:
        if graph[x + 1][y] == 0 and graph[x][y + 1] == 0 and graph[x + 1][y + 1] == 0:
            dfs(x + 1, y + 1, 2)


n = int(input())
result = 0

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

dfs(0, 1, 0)
print(result)