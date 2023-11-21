import sys
input = sys.stdin.readline
from collections import deque

N = int(input())

cnt = 0
for i in range(N):
    words = input().strip()
    stack = []

    for w in words:
        if len(stack) == 0:
            stack.append(w)
        elif stack[-1] == w:
            stack.pop()
        else:
            stack.append(w)

    if len(stack) == 0:
        cnt+=1

print(cnt)    