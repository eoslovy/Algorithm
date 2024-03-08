import sys
input = sys.stdin.readline

n,m = map(int, input().split())
num=[]
num.append(0)
num += list(map(int, input().split()))

dp = [0]*(n+1)
dp[1]=num[1]
dp[2]=num[1]+num[2]

for i in range(2,n+1):
    dp[i] = dp[i-1] + num[i]

for i in range(m):
    a,b=map(int,input().split())
    print(dp[b]-dp[a-1])