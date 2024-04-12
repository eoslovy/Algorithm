import sys
input = sys.stdin.readline
from collections import deque

n,m = map(int,input().split())

compare = [[] for _ in range(n+1)]
idx = [0] * (n+1)

for _ in range(m):
    a,b = map(int, input().split())
    compare[a].append(b)
    idx[b]+=1

zero = deque()
for i in range(1,n+1):
    if idx[i] == 0:
        zero.append(i)

result = []
while zero:
    x = zero.popleft()
    result.append(x)

    for i in compare[x]:
        idx[i]-=1
        if idx[i]==0:
            zero.append(i)
for i in range(1,n+1):
    if idx[i] != 0:
        print(i, end = ' ')
print(*result)