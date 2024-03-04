import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    a,b = map(int, input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))

    A.sort()
    B.sort()

    cnt = 0
    start = 0

    for i in range(a):
        while True:
            if start == b or A[i] <= B[start]:
                cnt+=start
                break
            else:
                start+=1

    print(cnt)