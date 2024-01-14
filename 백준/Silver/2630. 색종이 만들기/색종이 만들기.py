import sys
input = sys.stdin.readline
from collections import deque

def asd(N,x,y):
    global result1
    global result2
    
    if N == 1:
        if graph[x][y] == 0:
            result1 += 1
        elif graph[x][y] == 1:
            result2 += 1
        return
    

    stop = False
    for i in range(x,x+N):
        for j in range(y,y+N):
            if graph[i][j] != graph[x][y]:
                stop = True
                break
        if stop: 
            break
    
    if not stop:
        if graph[x][y] == 0:
            result1+=1
        elif graph[x][y] == 1:
            result2+=1

    else:
        asd(N//2,x,y)

        asd(N//2,x+N//2,y)

        asd(N//2,x,y+N//2)

        asd(N//2,x+N//2,y+N//2)

N = int(input())
graph = []   
result1 = 0
result2 = 0

for i in range(N):
    graph.append(list(map(int, input().split())))

asd(N,0,0)
print(result1)
print(result2)