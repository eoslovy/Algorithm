import sys
input = sys.stdin.readline
from collections import deque

def asd(N,x,y):
    stop = False
    for i in range(x,x+N):
        for j in range(y,y+N):
            if graph[i][j] != graph[x][y]:
                stop = True
                break
        if stop:break

    if not stop:
        print(graph[x][y], end = '')
    else:
        print('(', end = '')
        asd(N//2, x, y)
        asd(N//2, x, y + N//2)
        asd(N//2, x+ N//2, y)
        asd(N//2, x + N//2, y + N//2)
        print(')', end = '')


N = int(input())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().strip())))

asd(N,0,0)