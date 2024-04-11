import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

graph = []
while True:
    try:
        graph.append(int(input()))
    except:
        break

def postorder(left, right):
    if left>right:
        return
    else:
        mid = right+1
        for i in range(left+1,right+1):
            if graph[left]<graph[i]:
                mid=i
                break
        postorder(left+1,mid-1)
        postorder(mid,right)
        print(graph[left])

postorder(0,len(graph)-1)