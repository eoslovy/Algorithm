import sys
input = sys.stdin.readline
from collections import deque

def rotate(sticker):
    # 스티커를 90도 회전시키는 함수
    return list(zip(*sticker[::-1]))

def can_attach(x,y,sticker,notebook):
    # 스티커를 붙일 수 있는지 확인하는 함수
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            if sticker[i][j] == 1 and notebook[x+i][y+j] == 1:
                return False
    return True

def attach(x,y,sticker,notebook):
    # 스티커를 노트북에 붙이는 함수
    for i in range(len(sticker)):
        for j in range(len(sticker[0])):
            if sticker[i][j] == 1:
                notebook[x+i][y+j] = 1

N, M, K = map(int, input().split())
notebook = [[0]*M for _ in range(N)]


for i in range(K):
    R, C = map(int, input().split())
    sticker = [list(map(int, input().split())) for _ in range(R)]

    attached = False
    for _ in range(4):
        if attached:
            break
        for x in range(N - len(sticker) + 1):
            for y in range(M - len(sticker[0]) + 1):
                if can_attach(x,y,sticker,notebook):
                    attach(x,y,sticker,notebook)
                    attached = True
                    break
            if attached:
                break
        sticker = rotate(sticker)

cnt = 0
for i in range(N):
    for j in range(M):
        if notebook[i][j] == 1:
            cnt += 1
print(cnt)