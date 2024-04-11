import sys
input = sys.stdin.readline
from heapq import *

n = int(input())

card = []
for _ in range(n):
    x = int(input())
    card.append(x)

result = 0
heapify(card)

while True:
    tmp = len(card)
    if tmp == 1:
        break

    a = heappop(card)
    b = heappop(card)
    cnt = a+b
    result += cnt
    heappush(card, cnt)

print(result)