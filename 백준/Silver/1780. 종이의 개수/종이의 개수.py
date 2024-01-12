import sys
input = sys.stdin.readline
from collections import deque

def asd(N,x,y):
    global result

    if N == 1:
        if graph[x][y] == -1:
            result[0] += 1
        if graph[x][y] == 0:
            result[1] += 1
        if graph[x][y] == 1:
            result[2] += 1
        return

    stop = False
    for i in range(x,x+N):
        for j in range(y,y+N):
            if graph[i][j] != graph[x][y]:
                stop = True
                break
        if stop:break

    if stop:
        asd(N//3, x, y)
        asd(N//3, x, y + N//3)
        asd(N//3, x, y + N//3*2)
        
        asd(N//3, x + N//3, y)
        asd(N//3, x + N//3, y + N//3)
        asd(N//3, x + N//3, y + N//3*2)
        
        asd(N//3, x + N//3*2, y)
        asd(N//3, x + N//3*2, y + N//3)
        asd(N//3, x + N//3*2, y + N//3*2)
    else:
        if graph[x][y] == -1:
            result[0] += 1
        elif graph[x][y] == 0:
            result[1] += 1
        elif graph[x][y] == 1:
            result[2] += 1


N = int(input())
graph = []
result = [0] * 3
for i in range(N):
    graph.append(list(map(int, input().split())))

asd(N,0,0)

for i in range(3):
    print(result[i])