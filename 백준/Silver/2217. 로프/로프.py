import sys
input = sys.stdin.readline

n = int(input())

weight = []

for _ in range(n):
    weight.append(int(input()))

weight.sort(reverse = True)

rope = 0
lst = []
for i in range(n):
    lst.append(weight[i])
    tmp = lst[i] * len(lst)
    rope = max(rope, tmp)

print(rope)