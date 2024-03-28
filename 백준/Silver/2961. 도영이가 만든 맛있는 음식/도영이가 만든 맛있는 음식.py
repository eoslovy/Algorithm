import sys
input = sys.stdin.readline
from itertools import combinations

n = int(input())
s = []
b = []
result = []

for _ in range(n):
    x,y = map(int, input().split())
    s.append(x)
    b.append(y)

arr = []
for i in range(1,n+1):
    com = [list(item) for item in combinations(range(n), i)]
    arr+=com


for i in arr:
    cnt_s = 1
    cnt_b = 0
    for j in i:
        cnt_s*=s[j]
        cnt_b+=b[j]
    if cnt_s>cnt_b:
        result.append(cnt_s-cnt_b)
    else:
        result.append(cnt_b-cnt_s)

print(min(result))