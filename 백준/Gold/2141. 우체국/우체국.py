import sys
input = sys.stdin.readline

n = int(input())
x = []
cnt = 0

for _ in range(n):
    a,b = map(int, input().split())
    x.append([a,b])
    cnt+=b

x.sort()

tmp = 0
for i in x:
    tmp+=i[1]
    if tmp>=cnt/2:
        print(i[0])
        exit()