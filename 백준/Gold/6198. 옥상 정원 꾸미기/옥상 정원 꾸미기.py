import sys
input = sys.stdin.readline

N = int(input())

height=[]
for i in range(N):
    height.append(int(input()))

result=[0]*N
stack=[]

for i in range(N):
    h = height[i]
    while stack and h >= height[stack[-1]]:
        stack.pop()

    result[i]+=len(stack)
    stack.append(i)

print(sum(result))