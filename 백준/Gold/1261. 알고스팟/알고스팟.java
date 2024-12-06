import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] graph, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new int[n][m];


        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                if (tmp.charAt(j) == '0')
                    graph[i][j] = 0;
                if (tmp.charAt(j) == '1')
                    graph[i][j] = 1;
            }
        }

        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] == 0) {
                    if (graph[nx][ny] == 0) {
                        visited[nx][ny] = visited[x][y];
                        q.addFirst(new int[]{nx, ny});
                    }
                    if (graph[nx][ny] == 1) {
                        visited[nx][ny] = visited[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(visited[n - 1][m - 1] - 1);
    }
}
