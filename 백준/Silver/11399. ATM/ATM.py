import sys
input = sys.stdin.readline

n = int(input())
time = list(map(int, input().split()))

time.sort()

result = [0] * n
result[0] = time[0]

for i in range(1,n):
    result[i] = result[i-1] + time[i]


print(sum(result))