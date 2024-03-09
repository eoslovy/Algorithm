import sys
input = sys.stdin.readline

t = int(input())

f0=[1,0,1]
f1=[0,1,1]
res=[[1,0],[0,1],[1,1]]

for i in range(3, 41):
    f0.append(f0[i-1]+f0[i-2])
    f1.append(f1[i-1]+f1[i-2])
    res.append([f0[i],f1[i]])

for _ in range(t):
    n = int(input())
    print(*res[n])