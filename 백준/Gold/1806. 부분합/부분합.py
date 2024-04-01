import sys
input = sys.stdin.readline

n,s = map(int, input().split())
nums = list(map(int, input().split()))

start = 0
end = 1
cnt = nums[0]
answer=float('inf')
while True:
    if cnt<s:
        if end == n:
            break
        cnt+=nums[end]
        end+=1

    else:
        answer = min(answer, end-start)
        cnt-=nums[start]
        start+=1

if answer == float('inf'):
    answer = 0
print(answer)