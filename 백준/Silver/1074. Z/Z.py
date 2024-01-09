import sys
input = sys.stdin.readline
from collections import deque

n, r, c = map(int, input().split())

result = 0

def N(n, x, y):
    global result

    if x==r and y==c:
        print(int(result))
        exit(0)

    if n == 1:
        result += 1
        return

    if not(x<=r<x+n and y<=c<y+n):
        result += n*n
        return

    # 1사분면
    N(n/2, x, y)
    # 2사분면
    N(n/2, x, y+n/2)
    # 3사분면
    N(n/2, x+n/2, y)
    # 4사분면
    N(n/2, x+n/2, y+n/2)

N(2**n, 0, 0)