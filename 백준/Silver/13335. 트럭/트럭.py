import sys
input=sys.stdin.readline

n,w,L=map(int,input().split())
weight=list(map(int,input().split()))
bridge=[0]*w

cnt=0 
for i in range(n):
    tmp=weight[i]
    if sum(bridge) - bridge[0] + tmp <= L:
        for j in range(w-1):
            bridge[j]=bridge[j+1]
        bridge[w-1]=tmp
        cnt+=1

    elif sum(bridge) - bridge[0] + tmp > L:
        while sum(bridge) + tmp > L:
            for j in range(w-1):
                bridge[j]=bridge[j+1]
            bridge[w-1]=0
            cnt+=1

    if sum(bridge) + tmp <= L:
        bridge[w-1]=tmp

while sum(bridge) != 0:
    for i in range(w-1):
        bridge[i]=bridge[i+1]
    bridge[w-1]=0
    cnt+=1

print(cnt)