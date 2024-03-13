import sys
input = sys.stdin.readline

n,k = map(int, input().split())
coins = []
for _ in range(n):
    coin = int(input())
    coins.append(coin)

cnt = 0
for coin in sorted(coins, reverse=True):
    cnt += k//coin
    k %= coin

print(cnt)