import sys
input = sys.stdin.readline
from collections import deque

N = int(input())

for i in range(N):
    words = input().strip()
    stack = []

    for w in words:
        if w == '(':
            stack.append(w)
        elif w == ')':
            if len(stack) == 0:
                stack.append(w)
            elif stack[-1] == '(':
                stack.pop()
            else:
                stack.append(w)
    if len(stack) == 0:
        print('YES')
    else:
        print('NO')