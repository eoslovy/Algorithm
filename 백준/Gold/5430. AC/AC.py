import sys
input = sys.stdin.readline
from collections import deque

T = int(input())

for i in range(T):
    p = input().strip()
    n = int(input())
    x = input().strip()

    queue = deque(x[1:-1].split(','))
    
    if n == 0:
        queue = deque()
    flag = 0

    for j in p:
        if j == 'R':
            flag += 1
        elif j == 'D':
            if len(queue) == 0:
                print("error")
                break
            else:
                if flag % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
 
    else:
        if flag % 2 == 0:
            print("[" + ",".join(queue) + "]")
        else:
            queue.reverse()
            print("[" + ",".join(queue) + "]")