import java.util.*;

public class Main {
    private static int[][] arr;
    private static boolean[] visited1;
    private static boolean[] visited2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        int[][] graph = new int[m][2];
        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[i][0] = a;
            graph[i][1] = b;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        Arrays.sort(graph, (o1, o2) -> o1[0] - o2[0]);
//        System.out.println(Arrays.deepToString(graph));

        visited1 = new boolean[n+1];
        dfs(v, n);
        System.out.println();

        visited2 = new boolean[n+1];
        bfs(v, n);

        sc.close();
    }

    private static void dfs(int v, int n) {
        visited1[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !visited1[i]) {
                dfs(i, n);
            }
        }
    }

    private static void bfs(int v, int n) {
        int[] seq = new int[n + 1];
        int start = 0, end = 0;
        seq[end++] = v;
        visited2[v] = true;

        while (start < end) {
            int now = seq[start++];
            System.out.print(now + " ");

            for (int i = 1; i <= n; i++) {
                if (arr[now][i] == 1 && !visited2[i]) {
                    seq[end++] = i;
                    visited2[i] = true;
                }
            }
        }
    }
}
