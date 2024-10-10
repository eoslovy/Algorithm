import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = 1;
			int flag = 0;
			int[] visited = new int[n];
			while (true) {
				if (end >= n) {
					break;
				}
				if (graph[i][start] == graph[i][end]) {
					end++;
					if (end == n) {
						break;
					}
				} else if (graph[i][start] != graph[i][end]) {
					if (end + x > n && graph[i][start] > graph[i][end]) {
						flag = 1;
						break;
					}
					start = end - 1;
					if (graph[i][start] + 1 == graph[i][end]) {
						for (int j = start; j >= Math.max(0, start - x + 1); j--) {
							if (end - x < 0)
								flag = 1;
							if (graph[i][end - 1] != graph[i][j] || visited[j] == 1)
								flag = 1;
						}
						if (flag == 0) {
							for (int j = start; j >= Math.max(0, start - x + 1); j--) {
								visited[j] = 1;
							}
						}
					} else if (graph[i][start] - 1 == graph[i][end]) {
						for (int j = end; j < Math.min(n, end + x); j++) {
							if (end + x - 1 > n - 1)
								flag = 1;
							if (graph[i][end] != graph[i][j])
								flag = 1;
						}
						if (flag == 0) {
							for (int j = end; j < Math.min(n, end + x); j++) {
								visited[j] = 1;
							}
						}
					} else {
						flag = 1;
					}
					if (flag == 1)
						break;
					start += 1;
					end += 1;
				}
			}
			if (flag == 0) {
				ans++;
			}
		}

		int[][] tmpGraph = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmpGraph[i][j] = graph[j][i];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = tmpGraph[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = 1;
			int flag = 0;
			int[] visited = new int[n];
			while (true) {
				if (end >= n) {
					break;
				}
				if (graph[i][start] == graph[i][end]) {
					end++;
					if (end == n) {
						break;
					}
				}

				else if (graph[i][start] != graph[i][end]) {
					if (end + x > n && graph[i][start] > graph[i][end]) {
						flag = 1;
						break;
					}
					start = end - 1;
					if (graph[i][start] + 1 == graph[i][end]) {
						for (int j = start; j >= Math.max(0, start - x + 1); j--) {
							if (end - x < 0)
								flag = 1;
							if (graph[i][end - 1] != graph[i][j] || visited[j] == 1)
								flag = 1;
						}
						if (flag == 0) {
							for (int j = start; j >= Math.max(0, start - x + 1); j--) {
								visited[j] = 1;
							}
						}
					} else if (graph[i][start] - 1 == graph[i][end]) {
						for (int j = end; j < Math.min(n, end + x); j++) {
							if (end + x - 1 > n - 1)
								flag = 1;
							if (graph[i][end] != graph[i][j])
								flag = 1;
						}
						if (flag == 0) {
							for (int j = end; j < Math.min(n, end + x); j++) {
								visited[j] = 1;
							}
						}
					} else {
						flag = 1;
					}
					if (flag == 1)
						break;
					start += 1;
					end += 1;
				}
			}
			if (flag == 0) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}