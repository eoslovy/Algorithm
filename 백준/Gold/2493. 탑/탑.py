import sys
input = sys.stdin.readline

N = int(input())

height= list(map(int, input().split()))
ans=[0]*N
stack=[]

for i in range(N):
    h=height[i]
    while stack and height[stack[-1]] <h:
        stack.pop()
    if stack:
        ans[i]=stack[-1]+1
    stack.append(i)    

print(' '.join(map(str, ans)))