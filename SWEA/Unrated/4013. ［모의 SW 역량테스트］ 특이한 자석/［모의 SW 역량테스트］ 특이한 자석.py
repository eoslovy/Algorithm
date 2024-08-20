def soon(x):
    global graph
    tmp = graph[x][7]
    for i in range(6, -1, -1):
        graph[x][i + 1] = graph[x][i]
    graph[x][0] = tmp


def yeok(x):
    global graph
    tmp = graph[x][0]
    for i in range(7):
        graph[x][i] = graph[x][i + 1]
    graph[x][7] = tmp


t = int(input())

for tc in range(t):
    k = int(input())
    graph = []
    for i in range(4):
        graph.append(list(map(int, input().split())))

    order = []
    for i in range(k):
        a, b = map(int, input().split())
        order.append([a, b])

    for i, j in order:
        dir = [0, 0, 0, 0]
        dir[i - 1] = j

        # 왼쪽
        for k in range(i - 1, 0, -1):
            if graph[k][6] != graph[k - 1][2]:
                dir[k - 1] = -dir[k]
            else:
                break

        # 오른쪽
        for k in range(i - 1, 3):
            if graph[k][2] != graph[k + 1][6]:
                dir[k + 1] = -dir[k]
            else:
                break

        # 돌리기
        for k in range(4):
            if dir[k] == 1:
                soon(k)
            elif dir[k] == -1:
                yeok(k)

    cnt = 0
    if graph[0][0] == 1:
        cnt += 1
        # print('a')
    if graph[1][0] == 1:
        cnt += 2
        # print('b')
    if graph[2][0] == 1:
        cnt += 4
        # print('c')
    if graph[3][0] == 1:
        cnt += 8
        # print('d')
    print("#", end="")
    print(tc + 1, cnt)
