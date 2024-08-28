import java.io.*;
import java.util.*;

public class Solution {
	private static int n, start, cnt, ans;
	private static int[][] graph;
	private static int[] visited;
	private static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new int[101][101];
			visited = new int[101];
			q = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}

			cnt++;
			find(start);
			while (!q.isEmpty()) {
				cnt++;
				for (int i = 0; i < q.size(); i++) {
					find(q.poll());
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 101; i++) {
				max = Math.max(max, visited[i]);
			}

			for (int i = 0; i < 101; i++) {
				if (max == visited[i]) {
					ans = i;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void find(int x) {
		for (int i = 1; i < 101; i++) {
			if (graph[x][i] == 1) {
				if (visited[i] == 0) {
					q.add(i);
					visited[i] = cnt;
				}
			}
		}
	}
}