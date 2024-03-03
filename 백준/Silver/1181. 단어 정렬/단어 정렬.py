import sys
input = sys.stdin.readline
from collections import deque
from copy import deepcopy


N = int(input())
lst = []

for i in range(N):
    lst.append(input().strip())

set_lst = set(lst)
lst = list(set_lst)

lst.sort()
lst.sort(key = len)

for i in lst:
    print(i)