import sys
input = sys.stdin.readline

x = int(input())

cnt = 0
stick = [64,32,16,8,4,2,1]

for s in stick:
    cnt += x//s
    x%=s

print(cnt)