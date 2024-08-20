def dfs(cnt, lsum, rsum, mem):
    if dp[mem] > 0:  # 재귀를 다시 계산하지 않기 위해
        return dp[mem]

    if cnt == n:
        if lsum >= rsum:
            return 1
        return 0

    count = 0
    for i in range(n):
        if visit[i] == 1:
            continue
        visit[i] = 1
        count += dfs(cnt + 1, lsum + s[i], rsum, mem + mul[i] * 1)  # 왼쪽선택 1

        if rsum + s[i] <= lsum:
            count += dfs(cnt + 1, lsum, rsum + s[i], mem + mul[i] * 2)  # 오른쪽선택 2
        visit[i] = 0

    dp[mem] = count
    return dp[mem]


t = int(input())
mul = [1, 3, 9, 27, 81, 243, 729, 2187, 6561]

for tc in range(1, t + 1):
    n = int(input())
    s = list(map(int, input().split()))
    dp = [0] * (3**n)  # 메모이제이션 하기 위해 담을 공간
    visit = [0] * 11
    ans = dfs(0, 0, 0, 0)
    print("#", end="")
    print(tc, ans)
