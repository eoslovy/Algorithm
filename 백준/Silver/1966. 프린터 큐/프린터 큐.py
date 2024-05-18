import sys
input=sys.stdin.readline

test=int(input())

for i in range(test):
    n,m=map(int,input().split())
    num=list(map(int,input().split()))

    lst=[]
    for j in range(n):
        lst.append([num[j],j])

    cnt=1
    while lst:
        if lst[0][0]==max(num):
            if lst[0][1]==m:
                print(cnt)
                break
            lst.pop(0)
            num.remove(max(num))
            cnt+=1

        else:
            asd=lst[0]
            lst.pop(0)
            lst.append(asd)