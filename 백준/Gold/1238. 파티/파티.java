import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    private static int n, m, x;
    private static int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph, reverseGraph;
    static long[] dist1, dist2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        dist1 = new long[n + 1];
        dist2 = new long[n + 1];
        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            reverseGraph[to].add(new Edge(from, cost));
        }
        solve(x, dist1, graph);
        solve(x, dist2, reverseGraph);

        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist1[i] != INF && dist2[i] != INF) {
                result = Math.max(result, dist1[i] + dist2[i]);
            }
        }

        System.out.println(result);
    }

    private static void solve(int start, long[] dist, List<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.to;
            int cost = current.cost;

            if (dist[now] < cost)
                continue;

            for (Edge edge : graph[now]) {
                int next = edge.to;
                int nextCost = cost + edge.cost;

                if (dist[next] > nextCost) {
                    dist[next] = nextCost;
                    pq.add(new Edge(next, nextCost));
                }
            }
        }
    }
}