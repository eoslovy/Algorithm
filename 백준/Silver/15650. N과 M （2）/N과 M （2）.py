import sys
input = sys.stdin.readline

def dfs(cnt, start, ans):
    if cnt == m:
        print(*ans)
        return

    for i in range(start, n + 1):
        if visited[i] == 0:
            visited[i] = 1
            dfs(cnt + 1, i + 1, ans + [i])
            visited[i] = 0


n, m = map(int, input().split())
lst = []
visited = [0] * (n + 1)
for i in range(1, n + 1):
    lst.append(i)

dfs(0, 1, [])