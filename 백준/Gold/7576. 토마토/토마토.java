import java.util.*;
import java.io.*;

public class Main {
    static int m, n;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            st = new StringTokenizer(input, " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//		System.out.println(Arrays.deepToString(graph));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        bfs();

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, graph[i][j]);
            }
        }

        System.out.println(result - 1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] place = queue.poll();
            int x = place[0];
            int y = place[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}