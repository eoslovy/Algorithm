import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
