import sys
input = sys.stdin.readline
from collections import deque

def hanoi(N,start,end,tmp):
    if N == 1:
        print(start, end)
        return
    
    hanoi(N-1, start, tmp, end)
    print(start, end)

    hanoi(N-1, tmp, end, start)


K = int(input())

print(2**K -1)
hanoi(K,1,3,2)