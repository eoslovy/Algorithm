import java.io.*;
import java.util.*;

class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    private static int n, m;
    private static int INF = Integer.MAX_VALUE;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 간선 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        if (solve()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF)
                    System.out.println(-1);
                else
                    System.out.println(dist[i]);
            }
        }
    }

    private static boolean solve() {
        boolean updated = false;

        // n-1번 반복
        for (int i = 1; i < n; i++) {
            updated = false;
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    updated = true;
                }
            }
            if (!updated) break; // 더 이상 갱신이 없으면 종료
        }

        // 음수 사이클 체크
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                return true; // 음수 사이클 존재
            }
        }

        return false; // 음수 사이클 없음
    }
}