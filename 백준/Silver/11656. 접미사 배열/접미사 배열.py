import sys
input = sys.stdin.readline
from collections import deque
from itertools import combinations

S = str(input().split())

seq = []
for i in range(1, len(S)-3):
    tmp = []
    for j in range(i+1, len(S)-2):
        tmp += S[j]
    tmp_word = ''.join(tmp)
    seq.append(tmp_word)

seq.sort()
for s in seq:
    print(s)