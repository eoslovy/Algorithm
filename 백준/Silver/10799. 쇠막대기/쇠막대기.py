import sys
input = sys.stdin.readline

words = input().strip()

cnt = 0
stack = []
for i in range(len(words)):
    if words[i] == '(':
        stack.append(i)
    else:
        if words[i-1] == '(':
            stack.pop()
            cnt+=len(stack)
        else:
            stack.pop()
            cnt+=1

print(cnt)