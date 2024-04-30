import sys
input = sys.stdin.readline

n = int(input())
money = list(map(int, input().split()))
total = int(input())

money.sort()
tmp = sum(money)
if tmp<=total:
    print(money[-1])
    exit()

for i in range(n):
    tmp = total//(n-i)
    if tmp>money[i]:
        total-=money[i]
        continue
    else:
        print(tmp)
        exit()