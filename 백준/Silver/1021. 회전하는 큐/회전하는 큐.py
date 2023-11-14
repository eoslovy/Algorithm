import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
queue = deque()
cnt=0
ans=map(int,input().split())

for i in range(N):
    queue.append(i+1)
    
for i in ans:
    while True:
        if queue[0] == i:
            queue.popleft()
            break
        else:
            if queue.index(i)<len(queue)/2:
                while queue[0] != i:
                    queue.append(queue.popleft())
                    cnt+=1
            else:
                while queue[0] != i:
                    queue.appendleft(queue.pop())
                    cnt+=1

print(cnt)       