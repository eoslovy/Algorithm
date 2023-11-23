import sys
input = sys.stdin.readline

words = input().strip()

stack = []
cnt = 1
result = 0
for i in range(len(words)):
    if words[i] == '(':
        stack.append(words[i])
        cnt *= 2
    elif words[i] == '[':
        stack.append(words[i])
        cnt *= 3

    elif words[i] == ')':
        if not stack or stack[-1] == '[':
            result = 0
            break
        if words[i-1] == '(':
            result += cnt
        stack.pop()
        cnt//=2

    else:
        if not stack or stack[-1] == '(':
            result = 0
            break
        if words[i-1] == '[':
            result += cnt
        stack.pop()
        cnt//=3
        
if stack:
    print(0)
else:
    print(result)