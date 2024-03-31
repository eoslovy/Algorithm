import sys
input = sys.stdin.readline

n,l = map(int, input().split())

pound = []

for _ in range(n):
    x,y=map(int, input().split())
    pound.append([x,y])

pound.sort()

right = pound[0][1]
left = pound[0][0]
point = []
for i in range(1,n):
    start = pound[i][0]
    end = pound[i][1]

    if right >= start:
        if right >= end:
            continue
        else:
            right = end
    else:
        point.append([left,right])
        left = start
        right = end

point.append([left,right])

cnt = 0
tmp = point[0][0]
for i in point:
    if tmp < i[0]:
        tmp = i[0]
    while tmp < i[1]:
        tmp+=l
        cnt+=1

print(cnt)