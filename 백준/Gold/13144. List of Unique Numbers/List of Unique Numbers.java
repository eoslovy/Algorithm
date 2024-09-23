import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] visited = new int[100001];
    private static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            while (end < n && visited[graph[end]] == 0) {
                visited[graph[end]] = 1;
                end++;
            }
            ans += end - i;
            visited[graph[i]] = 0;
        }
        System.out.println(ans);
    }
}