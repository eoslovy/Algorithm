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
    private static int n, m, x;
    private static int INF = Integer.MAX_VALUE;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist1, dist2, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist1 = new long[n + 1];
        dist2 = new long[n + 1];
        result = new long[n + 1];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        dist1[x] = 0;
        dist2[x] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }
        solve();

        for (int i = 0; i < n + 1; i++) {
            if (dist1[i] != INF && dist2[i] != INF)
                result[i] = dist1[i] + dist2[i];
        }

        Arrays.sort(result);

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != INF) {
                System.out.println(result[i]);
                break;
            }
        }
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                if (dist1[edge.from] != INF && dist1[edge.to] > dist1[edge.from] + edge.cost) {
                    dist1[edge.to] = dist1[edge.from] + edge.cost;
                }
                if (dist2[edge.to] != INF && dist2[edge.from] > dist2[edge.to] + edge.cost) {
                    dist2[edge.from] = dist2[edge.to] + edge.cost;
                }
            }
        }
    }
}