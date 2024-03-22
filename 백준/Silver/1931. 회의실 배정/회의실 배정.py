import sys
input = sys.stdin.readline

n = int(input())
graph = []

for i in range(n):
    a,b = map(int, input().split())
    graph.append([a,b])

graph.sort(key = lambda x :(x[1],x[0]))

endPoint = 0
answer = 0
for start, end in graph:
    if endPoint <= start:
        answer+=1
        endPoint = end

print(answer)