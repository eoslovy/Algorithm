import sys
input = sys.stdin.readline

n=int(input())
m=int(input())

chu=list(map(int,input().split()))
cnt=[0]*100

ans=[]
for i in range(m):
    cnt[chu[i]-1]+=1
    if chu[i] in ans:
        continue

    if len(ans)==n:
        tmp=float('inf')
        for j in range(n):
            tmp=min(tmp,cnt[ans[j]-1])

        for j in range(n):
            if cnt[ans[j]-1]==tmp:
                cnt[ans[j]-1]=0
                ans.pop(j)
                break
        
        ans.append(chu[i])
    else:
        ans.append(chu[i])

print(*sorted(ans))