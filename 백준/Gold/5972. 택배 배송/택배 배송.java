import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int idx;
	int cost;

	public Node(int idx, int cost) {
		super();
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}

}

public class Main {
	private static int n;
	private static ArrayList<ArrayList<Node>> graph;
	private static int[] visited;
	private static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new int[n + 1];
		dist = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		for (int i = 0; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int nowIdx = now.idx;

			if (visited[nowIdx] == 1)
				continue;
			visited[nowIdx] = 1;

			for (Node node : graph.get(nowIdx)) {
				if (dist[node.idx] > dist[nowIdx] + node.cost) {
					dist[node.idx] = dist[nowIdx] + node.cost;
					pq.add(new Node(node.idx, dist[node.idx]));
				}
			}
		}
		System.out.println(dist[n]);

	}

}