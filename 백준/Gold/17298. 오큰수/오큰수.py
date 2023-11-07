import sys
input = sys.stdin.readline

N = int(input())

numbers = list(map(int, input().split()))

stack=[]
result=[-1]*N

for i in range(N):
    n = numbers[i]
    while stack and n > numbers[stack[-1]]:
        result[stack.pop()] = numbers[i]

    stack.append(i)

print(*result)