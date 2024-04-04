import sys
input = sys.stdin.readline

n,k = map(int, input().split())

line = []
for _ in range(n):
    x = int(input())
    line.append(x)

start = 1
end = max(line)

while start<=end:
    mid = (start+end)//2

    cnt = 0
    for i in range(n):
        cnt+=line[i]//mid

    if cnt >= k:
        start = mid+1
    else:
        end = mid-1

print(end)