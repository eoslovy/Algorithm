import sys
input = sys.stdin.readline


n = int(input())
nums = list(map(int, input().split()))
v = [1]*n

for i in range(1,n):
    for j in range(i):
        if nums[i]>nums[j]:
            v[i]=max(v[i],v[j]+1)
            
print(max(v))