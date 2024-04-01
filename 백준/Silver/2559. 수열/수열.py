import sys
input = sys.stdin.readline

n,k = map(int, input().split())

nums = list(map(int, input().split()))

tmp = 0
for i in range(k):
    tmp+=nums[i]

cnt = tmp

for i in range(0,n-k):
    tmp = tmp-nums[i]+nums[i+k]
    cnt = max(cnt, tmp)

print(cnt)