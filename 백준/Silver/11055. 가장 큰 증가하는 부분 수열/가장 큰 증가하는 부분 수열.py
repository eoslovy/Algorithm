import sys
input = sys.stdin.readline

n = int(input())

num = list(map(int, input().split()))
cnt = [1]*n
cnt[0]=num[0]
for i in range(1,n):
    for j in range(i):
        if num[i] > num[j]:
            cnt[i] = max(cnt[i], cnt[j]+num[i])
        else:
            cnt[i] = max(cnt[i], num[i])

print(max(cnt))