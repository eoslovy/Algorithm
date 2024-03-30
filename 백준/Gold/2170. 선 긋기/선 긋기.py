import sys
input = sys.stdin.readline

n = int(input())
line = []

for _ in range(n):
    x,y=map(int, input().split())
    line.append([x,y])

line.sort()

cnt = line[0][1] - line[0][0]
right = line[0][1]
for i in range(1,n):
    start = line[i][0]
    end = line[i][1]

    if right >= start:
        if right >= end:
            continue
        else:
            cnt += end - right
            right = end
    else:
        cnt += end - start
        right = end

print(cnt)