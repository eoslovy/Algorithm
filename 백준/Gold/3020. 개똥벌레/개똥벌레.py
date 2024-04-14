import sys
input = sys.stdin.readline
from bisect import bisect_left

n,h = map(int, input().split())

up = []
down = []
for i in range(1,n+1):
    x = int(input())
    if i%2==1:
        up.append(x)
    else:
        down.append(x)

up.sort()
down.sort()

result = float('inf')
for i in range(1,h+1):
    cnt_d = len(down) - bisect_left(down, i)
    cnt_u = len(up) - bisect_left(up, h-i+1)

    cnt=cnt_d+cnt_u

    if cnt < result:
        result = cnt
        real = 1
    elif cnt == result:
        real+=1

print(result,real)