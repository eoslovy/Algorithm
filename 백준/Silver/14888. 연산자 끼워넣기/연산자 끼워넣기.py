import sys
input=sys.stdin.readline

def dfs(x,cnt):
    global up,down
    if n == x+1:
        up=max(up,cnt)
        down=min(down,cnt)
        return
    
    if cal[0]!=0:
        cal[0]-=1
        dfs(x+1,cnt+num[x+1])
        cal[0]+=1

    if cal[1]!=0:
        cal[1]-=1
        dfs(x+1,cnt-num[x+1])
        cal[1]+=1

    if cal[2]!=0:
        cal[2]-=1
        dfs(x+1,cnt*num[x+1])
        cal[2]+=1

    if cal[3]!=0:
        if cnt<0:
            cal[3]-=1
            cnt=-cnt
            cnt=cnt//num[x+1]
            cnt=-cnt
            dfs(x+1,cnt)
            cal[3]+=1
        else:
            cal[3]-=1
            dfs(x+1,cnt//num[x+1])  
            cal[3]+=1   

    return       

n=int(input())
num=list(map(int,input().split()))
cal=list(map(int,input().split()))

up=-float('inf')
down=float('inf')

dfs(0,num[0])

print(up)
print(down)