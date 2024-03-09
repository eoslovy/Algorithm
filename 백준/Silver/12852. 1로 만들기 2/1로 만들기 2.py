import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * (n+1)
history = [0] * (n+1)

for i in range(2, n+1):
    dp[i] = dp[i-1]+1
    history[i] = i-1

    if i%3==0 and dp[i] > dp[i//3]+1:
        dp[i]=dp[i//3]+1
        history[i] = i//3
    if i%2==0 and dp[i] > dp[i//2]+1:
        dp[i]=dp[i//2]+1
        history[i] = i//2

print(dp[n])
print(n, end=" ")

backnum = n
while history[backnum]!=0:
    print(history[backnum], end=" ")
    backnum = history[backnum]

