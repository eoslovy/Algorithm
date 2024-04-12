import sys
input = sys.stdin.readline

n = int(input())
people = {}

for _ in range(n):
    name, status = map(str, input().split())
    people[name]=status

names = []
for key, value in people.items():
    if value == 'enter':
        names.append(key)

names.sort(reverse=True)
for i in names:
    print(i)