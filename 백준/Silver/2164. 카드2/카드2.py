import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
queue = deque([])

for i in range(N):
    queue.append(i+1)

while(len(queue)>= 2):
    queue.popleft()
    if len(queue) >= 2:
        queue.append(queue.popleft())

print(*queue)