import sys
input = sys.stdin.readline


n = int(input())
nums = list(map(int, input().split()))

stack = [-float('inf')]

def binary_search(target, start, end):
    while start<=end:
        mid = (start+end)//2

        if stack[mid]<target:
            start=mid+1
        else:
            end=mid-1
    
    return start

for i in nums:
    if stack[-1]<i:
        stack.append(i)
    else:
        stack[binary_search(i,0,len(stack)-1)]=i

print(len(stack)-1)