import sys
input = sys.stdin.readline

t = int(input())

d = [0]*(101)
d[1]=1
d[2]=1
d[3]=1
d[4]=2
d[5]=2
d[6]=3
d[7]=4
d[8]=5
d[9]=7
d[10]=9
for _ in range(t):
    n = int(input())
    if n<=10:
        print(d[n])
    else:
        for i in range(11,n+1):
            d[i] = d[i-1] + d[i-5]
        print(d[n])