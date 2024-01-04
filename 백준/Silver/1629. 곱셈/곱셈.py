import sys
input = sys.stdin.readline
from collections import deque

A, B, C = map(int, input().split())

def cal(A,B):
    if B == 1:
        return A % C
    else:
        tmp = cal(A,B//2)
        if B % 2 == 0:
            return (tmp * tmp) % C
        else:
            return (tmp * tmp * A) % C

print(cal(A,B))